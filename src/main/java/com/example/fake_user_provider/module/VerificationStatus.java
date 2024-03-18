package com.example.fake_user_provider.module;

import java.util.UUID;
import java.sql.Timestamp;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "verification_statuses")
@Data
@Builder
public class VerificationStatus {
    @Id
    private UUID id;
    private Timestamp created;
    private Timestamp updated;
    private UUID profileId;
    private String profileType;
    private String details;
    private String verificationStatus;
    @Transient
    private User user;
}
