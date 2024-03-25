package com.dosmakhambetbaktiyar.fake_user_provider.service.impl;

import com.dosmakhambetbaktiyar.fake_user_provider.module.MerchantMemberInvitation;
import com.dosmakhambetbaktiyar.fake_user_provider.repository.MerchantMemberInvitationRepository;
import com.dosmakhambetbaktiyar.fake_user_provider.service.MerchantMemberInvitationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MerchantMemberInvitationServiceImpl implements MerchantMemberInvitationService {
    private final MerchantMemberInvitationRepository repository;
    @Override
    public Mono<MerchantMemberInvitation> save(MerchantMemberInvitation entity) {
        assert entity.getId() == null;

        return repository.save(entity);
    }

    @Override
    public Mono<MerchantMemberInvitation> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    @Override
    public Mono<MerchantMemberInvitation> update(UUID uuid, MerchantMemberInvitation entity) {
        if(uuid == null) {
            return Mono.error(new IllegalArgumentException("Id must not be null"));
        }

        return repository.save(entity);
    }

    @Override
    public Flux<MerchantMemberInvitation> findAll(Pageable pageable) {
        return repository.findAll(pageable.getOffset(), pageable.getPageSize());
    }

    @Override
    public Mono<Void> delete(UUID uuid) {
        return repository.deleteById(uuid);
    }
}
