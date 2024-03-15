package com.example.fake_user_provider.module;

import java.util.UUID;
import java.sql.Timestamp;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "individuals")
@Data
@Builder
public class Individual {
    @Id
    private UUID id;
    private UUID userId;
    private Timestamp created;
    private Timestamp updated;
    private String passportNumber;
    private String phoneNumber;
    private String email;
    private Timestamp verifiedAt;
    private Timestamp archivedAt;
    private String status;

    private User user;
}
