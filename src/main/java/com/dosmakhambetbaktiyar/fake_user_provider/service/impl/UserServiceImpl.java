package com.dosmakhambetbaktiyar.fake_user_provider.service.impl;

import com.dosmakhambetbaktiyar.fake_user_provider.module.User;
import com.dosmakhambetbaktiyar.fake_user_provider.repository.UserRepository;
import com.dosmakhambetbaktiyar.fake_user_provider.service.AddressService;
import com.dosmakhambetbaktiyar.fake_user_provider.service.UserService;
import com.enums.UserStatus;
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
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final AddressService addressService;

    public Mono<User> save(User entity) {

        entity.setCreated(Timestamp.from(Instant.now()));
        entity.setUpdated(Timestamp.from(Instant.now()));
        entity.setVerifiedAt(Timestamp.from(Instant.now()));
        entity.setArchivedAt(Timestamp.from(Instant.now().plus(1, ChronoUnit.YEARS)));
        entity.setSecretKey(UUID.randomUUID().toString());
        entity.setStatus(UserStatus.ACTIVE);
        entity.setFilled(entity.getAddress() != null);

        if (entity.getAddress() != null && entity.getAddress().getId() == null) {
            return addressService.save(entity.getAddress())
                    .map(address -> {
                        entity.setAddress(address);
                        return entity;
                    }).flatMap(repository::save);
        } else if (entity.getAddress() != null && entity.getAddress().getId() != null) {
            return addressService.findById(entity.getAddress().getId())
                    .switchIfEmpty(Mono.error(new IllegalArgumentException("Address not found")))
                    .map(address -> {
                        entity.setAddress(address);
                        return entity;
                    }).flatMap(repository::save);
        }else {
            return repository.save(entity);
        }
    }

    public Mono<User> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Mono<User> update(UUID uuid, User entity) {
        if (uuid == null) {
            return Mono.error(new IllegalArgumentException("Id must not be null"));
        }
        entity.setId(uuid);
        return repository.save(entity);
    }

    public Flux<User> findAll(Pageable pageable) {
        return repository.findAll();
    }

    public Mono<Void> delete(UUID uuid) {
        return repository.deleteById(uuid);
    }

}
