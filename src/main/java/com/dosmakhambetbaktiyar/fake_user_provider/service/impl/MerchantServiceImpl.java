package com.dosmakhambetbaktiyar.fake_user_provider.service.impl;

import com.dosmakhambetbaktiyar.fake_user_provider.module.Merchant;
import com.dosmakhambetbaktiyar.fake_user_provider.module.MerchantMember;
import com.dosmakhambetbaktiyar.fake_user_provider.module.MerchantMemberInvitation;
import com.dosmakhambetbaktiyar.fake_user_provider.repository.MerchantMemberInvitationRepository;
import com.dosmakhambetbaktiyar.fake_user_provider.repository.MerchantMemberRepository;
import com.dosmakhambetbaktiyar.fake_user_provider.repository.MerchantRepository;
import com.dosmakhambetbaktiyar.fake_user_provider.service.MerchantMemberInvitationService;
import com.dosmakhambetbaktiyar.fake_user_provider.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

//TODO: использовать сервис другого модуля или репозиторий другого модуля ?

@Service
@RequiredArgsConstructor
public class MerchantServiceImpl implements MerchantService {
    private final MerchantRepository repository;
    private final MerchantMemberInvitationRepository merchantMemberInvitationRepository;
    private final MerchantMemberRepository merchantMemberRepository;

    public Mono<Merchant> save(Merchant entity) {
        assert entity.getId() == null;
        entity.setCreatorId(entity.getCreator().getId());
        entity.setArchivedAt(Timestamp.from(Instant.now().plus(365, ChronoUnit.DAYS)));
        return repository.save(entity);
    }

    public Mono<Merchant> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Mono<Merchant> update(UUID uuid, Merchant entity) {
        if(uuid == null) {
            return Mono.error(new IllegalArgumentException("Id must not be null"));
        }

        entity.setId(uuid);
        return repository.save(entity);
    }

    public Flux<Merchant> findAll(Pageable pageable) {
        return repository.findAll();
    }

    public Mono<Void> delete(UUID uuid) {
        return repository.deleteById(uuid);
    }

    public Flux<MerchantMemberInvitation> findAllInvitations(UUID merchantId, Pageable pageable){
        return merchantMemberInvitationRepository.findAllByMerchantId(merchantId, pageable.getOffset(), pageable.getPageSize());
    }

    public Flux<MerchantMember> findAllMembers(UUID merchantId, Pageable pageable){
        return merchantMemberRepository.findAllByMerchantId(merchantId, pageable.getOffset(), pageable.getPageSize());
    }

}
