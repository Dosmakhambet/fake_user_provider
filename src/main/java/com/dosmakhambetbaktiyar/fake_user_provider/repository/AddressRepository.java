package com.dosmakhambetbaktiyar.fake_user_provider.repository;

import com.dosmakhambetbaktiyar.fake_user_provider.module.Address;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface AddressRepository extends ReactiveCrudRepository<Address, UUID> {

    @Query("SELECT * FROM person.addresses LIMIT :limit OFFSET :offset")
    Flux<Address> findAll(long offset, int limit);
}
