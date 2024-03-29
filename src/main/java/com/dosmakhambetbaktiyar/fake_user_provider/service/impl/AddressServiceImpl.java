package com.dosmakhambetbaktiyar.fake_user_provider.service.impl;

import com.dosmakhambetbaktiyar.fake_user_provider.module.Address;
import com.dosmakhambetbaktiyar.fake_user_provider.repository.AddressRepository;
import com.dosmakhambetbaktiyar.fake_user_provider.repository.CountryRepository;
import com.dosmakhambetbaktiyar.fake_user_provider.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository repository;
    private final CountryRepository countryRepository;

    public Mono<Address> save(Address entity) {
        assert entity != null;

        if (entity.getId() != null) {
            return Mono.error(new IllegalArgumentException("Id must be null"));
        }

        entity.setArchived(Timestamp.from(Instant.now().plus(365, ChronoUnit.DAYS)));

        if (entity.getCountry().getId() != null) {
            return countryRepository.findById(entity.getCountry().getId())
                    .switchIfEmpty(Mono.error(new IllegalArgumentException("Country not found")))
                    .map(country -> {
                        entity.setCountryId(country.getId());
                        entity.setCountry(country);
                        return entity;
                    })
                    .flatMap(repository::save);
        }

        return countryRepository.save(entity.getCountry())
                .map(country -> {
                    entity.setCountryId(country.getId());
                    return entity;
                })
                .flatMap(repository::save);
    }

    public Mono<Address> findById(UUID uuid) {
        return repository.findById(uuid)
                .flatMap(address -> countryRepository.findById(address.getCountryId())
                        .map(country -> {
                            address.setCountry(country);
                            return address;
                        })
                );
    }

    public Mono<Address> update(UUID uuid, Address entity) {
        assert uuid != null;

        entity.setId(uuid);

        return repository.save(entity)
                .flatMap(address -> countryRepository.findById(address.getCountryId())
                        .map(country -> {
                            address.setCountry(country);
                            return address;
                        })
                );
    }

    public Flux<Address> findAll(Pageable pageable) {
        return repository.findAll(pageable.getOffset(), pageable.getPageSize());
    }

    public Mono<Void> delete(UUID uuid) {
        return repository.deleteById(uuid);
    }
}
