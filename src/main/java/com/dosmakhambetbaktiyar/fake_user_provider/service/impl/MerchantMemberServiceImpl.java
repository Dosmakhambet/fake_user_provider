package com.dosmakhambetbaktiyar.fake_user_provider.service.impl;

import com.dosmakhambetbaktiyar.fake_user_provider.mapper.UserMapper;
import com.dosmakhambetbaktiyar.fake_user_provider.module.MerchantMember;
import com.dosmakhambetbaktiyar.fake_user_provider.module.MerchantMemberInvitation;
import com.dosmakhambetbaktiyar.fake_user_provider.module.User;
import com.dosmakhambetbaktiyar.fake_user_provider.repository.MerchantMemberInvitationRepository;
import com.dosmakhambetbaktiyar.fake_user_provider.repository.MerchantMemberRepository;
import com.dosmakhambetbaktiyar.fake_user_provider.repository.UserRepository;
import com.dosmakhambetbaktiyar.fake_user_provider.service.MerchantMemberService;
import com.dosmakhambetbaktiyar.fake_user_provider.service.UserService;
import com.enums.Role;
import com.enums.UserStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MerchantMemberServiceImpl implements MerchantMemberService {
    private final MerchantMemberRepository repository;
    private final MerchantMemberInvitationRepository merchantMemberInvitationRepository;
    private final UserService userService;
    private final UserMapper userMapper;

    public Mono<MerchantMember> save(MerchantMemberInvitation invitation) {
        assert invitation.getId() != null;

        return merchantMemberInvitationRepository.findById(invitation.getId())
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Invitation not found")))
                .filter(inv -> inv.getExpires().after(Timestamp.from(Instant.now())))
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Invitation expired")))
                .map(userMapper::toEntity)
                .flatMap(userService::save)
                .flatMap(user -> saveMerchantMember(user.getId(), invitation.getMerchantId(), Role.USER));
    }

    public Mono<MerchantMember> save(MerchantMember entity) {
        return repository.save(entity);
    }

    public Mono<MerchantMember> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Mono<MerchantMember> update(UUID uuid, MerchantMember entity) {
        if (uuid == null) {
            return Mono.error(new IllegalArgumentException("Id must not be null"));
        }
        entity.setId(uuid);
        return repository.save(entity);
    }

    public Flux<MerchantMember> findAll(Pageable pageable) {
        return repository.findAll();
    }

    public Mono<Void> delete(UUID uuid) {
        return repository.deleteById(uuid);
    }

    public Mono<MerchantMember> saveIndividual(UUID individualId, User user) {
        return userService.save(user)
                .map(u -> {
                    user.setId(u.getId());
                    return user;
                })
                .flatMap(u -> saveMerchantMember(u.getId(), individualId, Role.USER));
    }
    private Mono<MerchantMember> saveMerchantMember(UUID userId, UUID merchantId, Role role) {
        MerchantMember member = MerchantMember.builder()
                .created(Timestamp.from(Instant.now()))
                .updated(Timestamp.from(Instant.now()))
                .merchantId(merchantId)
                .userId(userId)
                .memberRole(role)
                .build();
        return repository.save(member);
    }
}
