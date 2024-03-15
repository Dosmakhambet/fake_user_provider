package com.example.fake_user_provider.module;

import java.util.UUID;
import java.sql.Timestamp;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table(name = "profile_history")
@Data
@Builder
public class ProfileHistory {
    @Id
    private UUID id;
    private Timestamp created;
    private UUID profileId;
    private String profileType;
    private String reason;
    private String comment;
    private String changedValues;

    private User user;
}
