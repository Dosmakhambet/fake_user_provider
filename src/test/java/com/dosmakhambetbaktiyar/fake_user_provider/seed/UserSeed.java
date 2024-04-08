package com.dosmakhambetbaktiyar.fake_user_provider.seed;

import com.dosmakhambetbaktiyar.fake_user_provider.module.User;
import com.enums.UserStatus;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class UserSeed {
    public User createUser1() {
        return User.builder()
                .secretKey("secretKey1")
                .created(new Timestamp(System.currentTimeMillis()))
                .updated(new Timestamp(System.currentTimeMillis()))
                .firstName("John")
                .lastName("Doe")
                .verifiedAt(new Timestamp(System.currentTimeMillis()))
                .archivedAt(new Timestamp(System.currentTimeMillis()))
                .status(UserStatus.ACTIVE)
                .filled(true)
                .addressId(UUID.randomUUID())

                .build();
    }

    public User createUser2() {
        return User.builder()
                .secretKey("secretKey2")
                .created(new Timestamp(System.currentTimeMillis()))
                .updated(new Timestamp(System.currentTimeMillis()))
                .firstName("Jane")
                .lastName("Doe")
                .verifiedAt(new Timestamp(System.currentTimeMillis()))
                .archivedAt(new Timestamp(System.currentTimeMillis()))
                .status(UserStatus.ACTIVE)
                .filled(true)
                .build();
    }
}
