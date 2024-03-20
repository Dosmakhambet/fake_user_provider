package com.example.fake_user_provider.service.impl;

import com.example.fake_user_provider.module.Address;
import com.example.fake_user_provider.repository.AddressRepository;
import com.example.fake_user_provider.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.print.Pageable;
import java.util.UUID;

//TODO: add pageable to findAll
@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository repository;
    public Mono<Address> save(Address entity) {
        return repository.save(entity);
    }

    public Mono<Address> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Mono<Address> update(Address entity) {
        return repository.save(entity);
    }

    public Flux<Address> findAll(Pageable pageable) {
        return repository.findAll();
    }

    public Mono<Void> delete(UUID uuid) {
        return repository.deleteById(uuid);
    }
}
