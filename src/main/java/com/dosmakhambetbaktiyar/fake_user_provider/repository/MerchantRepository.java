package com.dosmakhambetbaktiyar.fake_user_provider.repository;

import com.dosmakhambetbaktiyar.fake_user_provider.module.Merchant;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface MerchantRepository extends ReactiveCrudRepository<Merchant, UUID> {

    @Query("SELECT * FROM person.merchants OFFSET :offset LIMIT :limit")
    Flux<Merchant> findAll(long offset, int limit);
}
