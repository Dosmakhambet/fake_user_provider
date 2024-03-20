package com.example.fake_user_provider.service.impl;

import com.example.fake_user_provider.module.MerchantMember;
import com.example.fake_user_provider.repository.MerchantMemberRepository;
import com.example.fake_user_provider.service.MerchantMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.print.Pageable;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MerchantMemberServiceImpl implements MerchantMemberService {
    private final MerchantMemberRepository repository;
    public Mono<MerchantMember> save(MerchantMember entity) {
        return repository.save(entity);
    }

    public Mono<MerchantMember> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Mono<MerchantMember> update(MerchantMember entity) {
        return repository.save(entity);
    }

    public Flux<MerchantMember> findAll(Pageable pageable) {
        return repository.findAll();
    }

    public Mono<Void> delete(UUID uuid) {
        return repository.deleteById(uuid);
    }
}
