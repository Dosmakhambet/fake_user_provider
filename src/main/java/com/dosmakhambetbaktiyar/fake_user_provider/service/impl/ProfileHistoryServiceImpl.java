package com.dosmakhambetbaktiyar.fake_user_provider.service.impl;

import com.dosmakhambetbaktiyar.fake_user_provider.module.ProfileHistory;
import com.dosmakhambetbaktiyar.fake_user_provider.repository.ProfileHistoryRepository;
import com.dosmakhambetbaktiyar.fake_user_provider.service.ProfileHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.data.domain.Pageable;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileHistoryServiceImpl implements ProfileHistoryService {
    private final ProfileHistoryRepository repository;
    public Mono<ProfileHistory> save(ProfileHistory entity) {
        return repository.save(entity);
    }

    public Mono<ProfileHistory> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Mono<ProfileHistory> update(UUID uuid, ProfileHistory entity) {
        if(uuid == null) {
            return Mono.error(new IllegalArgumentException("Id must not be null"));
        }
        entity.setId(uuid);
        return repository.save(entity);
    }

    public Flux<ProfileHistory> findAll(Pageable pageable) {
        return repository.findAll();
    }

    public Mono<Void> delete(UUID uuid) {
        return repository.deleteById(uuid);
    }
}
