package com.dosmakhambetbaktiyar.fake_user_provider.module;

import java.util.UUID;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "person.addresses")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private Long countryId;
    @Transient
    private Country country;

}
