package com.dosmakhambetbaktiyar.fake_user_provider.service;

import com.dosmakhambetbaktiyar.fake_user_provider.module.Individual;
import com.dosmakhambetbaktiyar.fake_user_provider.module.User;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface IndividualService extends BaseService<Individual, UUID>{
    Mono<Individual> save(Individual entity, User user);
}
