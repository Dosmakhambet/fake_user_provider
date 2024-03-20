package com.example.fake_user_provider.service.impl;

import com.example.fake_user_provider.module.Individual;
import com.example.fake_user_provider.repository.IndividualRepository;
import com.example.fake_user_provider.service.IndividualService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.print.Pageable;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IndividualServiceImpl implements IndividualService {
    private final IndividualRepository repository;

    public Mono<Individual> save(Individual entity) {
        return repository.save(entity);
    }

    public Mono<Individual> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Mono<Individual> update(Individual entity) {
        return repository.save(entity);
    }

    public Flux<Individual> findAll(Pageable pageable) {
        return repository.findAll();
    }

    public Mono<Void> delete(UUID uuid) {
        return repository.deleteById(uuid);
    }
}
