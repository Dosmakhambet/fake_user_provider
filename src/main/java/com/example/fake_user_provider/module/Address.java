package com.example.fake_user_provider.module;

import java.util.UUID;
import java.sql.Timestamp;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "addresses")
@Data
@Builder
public class Address {
    @Id
    private UUID id;
    private Timestamp created;
    private Timestamp updated;
    private String address;
    private String zipCode;
    private Timestamp archived;
    private String city;
    private String state;

    private int countryId;
    @Transient
    private Country country;

}
