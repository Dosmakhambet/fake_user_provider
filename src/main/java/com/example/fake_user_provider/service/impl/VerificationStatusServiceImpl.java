package com.example.fake_user_provider.service.impl;

import com.example.fake_user_provider.module.VerificationStatus;
import com.example.fake_user_provider.repository.VerificationStatusRepository;
import com.example.fake_user_provider.service.VerificationStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.print.Pageable;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VerificationStatusServiceImpl implements VerificationStatusService {
    private final VerificationStatusRepository repository;
    public Mono<VerificationStatus> save(VerificationStatus entity) {
        return repository.save(entity);
    }

    public Mono<VerificationStatus> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Mono<VerificationStatus> update(VerificationStatus entity) {
        return repository.save(entity);
    }

    public Flux<VerificationStatus> findAll(Pageable pageable) {
        return repository.findAll();
    }

    public Mono<Void> delete(UUID uuid) {
        return repository.deleteById(uuid);
    }
}
