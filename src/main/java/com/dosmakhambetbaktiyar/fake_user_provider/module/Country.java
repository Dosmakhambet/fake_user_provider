package com.dosmakhambetbaktiyar.fake_user_provider.module;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "person.countries")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
    private Long id;
    private Timestamp created;
    private Timestamp updated;
    private String name;
    private String alpha2;
    private String alpha3;
    private String status;
}