package com.example.fake_user_provider.repository;

import com.example.fake_user_provider.module.ProfileHistory;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfileHistoryRepository extends ReactiveCrudRepository<ProfileHistory, UUID> {
}
