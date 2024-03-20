package com.example.fake_user_provider.service.impl;

import com.example.fake_user_provider.module.Country;
import com.example.fake_user_provider.repository.CountryRepository;
import com.example.fake_user_provider.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.print.Pageable;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository repository;
    public Mono<Country> save(Country entity) {
        return repository.save(entity);
    }

    public Mono<Country> findById(Long aLong) {
        return repository.findById(aLong);
    }

    public Mono<Country> update(Country entity) {
        return repository.save(entity);
    }

    public Flux<Country> findAll(Pageable pageable) {
        return repository.findAll();
    }

    public Mono<Void> delete(Long aLong) {
        return repository.deleteById(aLong);
    }
}
