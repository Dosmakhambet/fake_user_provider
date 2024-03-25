package com.dosmakhambetbaktiyar.fake_user_provider.service.impl;

import com.dosmakhambetbaktiyar.fake_user_provider.module.Individual;
import com.dosmakhambetbaktiyar.fake_user_provider.module.MerchantMember;
import com.dosmakhambetbaktiyar.fake_user_provider.module.User;
import com.dosmakhambetbaktiyar.fake_user_provider.repository.IndividualRepository;
import com.dosmakhambetbaktiyar.fake_user_provider.repository.MerchantMemberRepository;
import com.dosmakhambetbaktiyar.fake_user_provider.repository.UserRepository;
import com.dosmakhambetbaktiyar.fake_user_provider.service.IndividualService;
import com.enums.IndividualStatus;
import com.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.data.domain.Pageable;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IndividualServiceImpl implements IndividualService {
    private final IndividualRepository repository;
    private final UserRepository userRepository;
    private final MerchantMemberRepository merchantMemberRepository;

    public Mono<Individual> save(Individual entity) {

        return repository.save(entity);
    }

    public Mono<Individual> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Mono<Individual> update(UUID uuid, Individual entity) {
        if(uuid == null) {
            return Mono.error(new IllegalArgumentException("Id must not be null"));
        }

        entity.setId(uuid);
        return repository.save(entity);
    }

    public Flux<Individual> findAll(Pageable pageable) {
        return repository.findAll();
    }

    public Mono<Void> delete(UUID uuid) {
        return repository.deleteById(uuid);
    }

    public Mono<Individual> save(Individual entity, User user) {

        return userRepository.save(user)
                .map(u -> {
                    entity.setUser(u);
                    entity.setUserId(u.getId());
                    entity.setCreated(u.getCreated());
                    entity.setUpdated(u.getUpdated());
                    entity.setVerifiedAt(u.getVerifiedAt());
                    entity.setStatus(IndividualStatus.ACTIVE);
                    return entity;
                })
                .flatMap(repository::save)
                .map(individual -> {
                    MerchantMember member = MerchantMember.builder()
                            .created(individual.getCreated())
                            .updated(individual.getUpdated())
                            .merchantId(individual.getId())
                            .userId(individual.getUserId())
                            .memberRole(Role.ADMIN)
                            .individual(individual)
                            .build();
                    return member;
                }).flatMap(merchantMemberRepository::save)
                .map(MerchantMember::getIndividual);
    }
}
