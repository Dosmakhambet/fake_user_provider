package com.dosmakhambetbaktiyar.fake_user_provider.repository;

import com.dosmakhambetbaktiyar.fake_user_provider.module.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, UUID> {
}
