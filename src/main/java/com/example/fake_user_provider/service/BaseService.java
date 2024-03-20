package com.example.fake_user_provider.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.print.Pageable;

public interface BaseService<E,ID>{
    Mono<E> save(E entity);
    Mono<E> findById(ID id);
    Mono<E> update(E entity);
    Flux<E> findAll(Pageable pageable);
    Mono<Void> delete(ID id);
}
