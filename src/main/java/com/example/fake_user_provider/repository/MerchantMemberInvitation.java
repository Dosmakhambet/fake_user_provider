package com.example.fake_user_provider.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MerchantMemberInvitation extends ReactiveCrudRepository<MerchantMemberInvitation, UUID> {
}
