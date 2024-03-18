package com.example.fake_user_provider.repository;

import com.example.fake_user_provider.module.Country;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends ReactiveCrudRepository<Country, Long> {
}
