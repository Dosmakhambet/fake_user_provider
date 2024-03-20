package com.example.fake_user_provider.service.impl;

import com.example.fake_user_provider.module.Merchant;
import com.example.fake_user_provider.repository.MerchantRepository;
import com.example.fake_user_provider.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.print.Pageable;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MerchantServiceImpl implements MerchantService {
    private final MerchantRepository repository;
    public Mono<Merchant> save(Merchant entity) {
        return repository.save(entity);
    }

    public Mono<Merchant> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Mono<Merchant> update(Merchant entity) {
        return repository.save(entity);
    }

    public Flux<Merchant> findAll(Pageable pageable) {
        return repository.findAll();
    }

    public Mono<Void> delete(UUID uuid) {
        return repository.deleteById(uuid);
    }
}
