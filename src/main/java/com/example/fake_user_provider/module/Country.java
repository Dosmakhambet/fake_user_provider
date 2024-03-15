package com.example.fake_user_provider.module;

import java.sql.Timestamp;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "countries")
@Data
@Builder
public class Country {
    @Id
    private int id;
    private Timestamp created;
    private Timestamp updated;
    private String name;
    private String alpha2;
    private String alpha3;
    private String status;
}