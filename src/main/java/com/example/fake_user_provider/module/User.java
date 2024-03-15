package com.example.fake_user_provider.module;

import java.util.UUID;
import java.sql.Timestamp;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "users")
@Data
@Builder
public class User {
    @Id
    private UUID id;
    private String secretKey;
    private Timestamp created;
    private Timestamp updated;
    private String firstName;
    private String lastName;
    private Timestamp verifiedAt;
    private Timestamp archivedAt;
    private String status;
    private boolean filled;

    private UUID addressId;
    @Transient
    private Address address;
}
