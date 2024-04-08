package com.dosmakhambetbaktiyar.fake_user_provider.seed;

import com.dosmakhambetbaktiyar.fake_user_provider.module.Address;

import java.sql.Timestamp;
import java.time.Instant;

public class AddressSeed {

    public AddressSeed() {
    }
    public Address createAddress1() {
        return Address.builder()
                .city("Almaty")
                .address("Abay")
                .zipCode("050000")
                .created(Timestamp.from(Instant.now()))
                .updated(Timestamp.from(Instant.now()))
                .archived(Timestamp.from(Instant.now()))
                .build();
    }

    public Address createAddress2() {
        return Address.builder()
                .city("New York")
                .address("Broadway")
                .zipCode("10007")
                .created(Timestamp.from(Instant.now()))
                .updated(Timestamp.from(Instant.now()))
                .archived(Timestamp.from(Instant.now()))
                .build();
    }
}
