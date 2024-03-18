package com.example.fake_user_provider.repository;

import com.example.fake_user_provider.module.Address;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepository extends ReactiveCrudRepository<Address, UUID> {
}
