package com.example.fake_user_provider.service.impl;

import com.example.fake_user_provider.module.User;
import com.example.fake_user_provider.repository.UserRepository;
import com.example.fake_user_provider.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.print.Pageable;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    public Mono<User> save(User entity) {
        return repository.save(entity);
    }

    public Mono<User> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Mono<User> update(User entity) {
        return repository.save(entity);
    }

    public Flux<User> findAll(Pageable pageable) {
        return repository.findAll();
    }

    public Mono<Void> delete(UUID uuid) {
        return repository.deleteById(uuid);
    }
}
