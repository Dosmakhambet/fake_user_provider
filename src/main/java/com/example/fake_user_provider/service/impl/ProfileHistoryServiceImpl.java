package com.example.fake_user_provider.service.impl;

import com.example.fake_user_provider.module.ProfileHistory;
import com.example.fake_user_provider.repository.ProfileHistoryRepository;
import com.example.fake_user_provider.service.ProfileHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.print.Pageable;
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

    public Mono<ProfileHistory> update(ProfileHistory entity) {
        return repository.save(entity);
    }

    public Flux<ProfileHistory> findAll(Pageable pageable) {
        return repository.findAll();
    }

    public Mono<Void> delete(UUID uuid) {
        return repository.deleteById(uuid);
    }
}
