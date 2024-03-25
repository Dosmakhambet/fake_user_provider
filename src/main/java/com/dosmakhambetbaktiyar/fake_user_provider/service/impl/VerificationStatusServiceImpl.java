package com.dosmakhambetbaktiyar.fake_user_provider.service.impl;

import com.dosmakhambetbaktiyar.fake_user_provider.module.VerificationStatus;
import com.dosmakhambetbaktiyar.fake_user_provider.repository.VerificationStatusRepository;
import com.dosmakhambetbaktiyar.fake_user_provider.service.VerificationStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.data.domain.Pageable;
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

    public Mono<VerificationStatus> update(UUID uuid, VerificationStatus entity) {
        if (uuid == null) {
            return Mono.error(new IllegalArgumentException("Id must not be null"));
        }
        entity.setId(uuid);
        return repository.save(entity);
    }

    public Flux<VerificationStatus> findAll(Pageable pageable) {
        return repository.findAll();
    }

    public Mono<Void> delete(UUID uuid) {
        return repository.deleteById(uuid);
    }
}
