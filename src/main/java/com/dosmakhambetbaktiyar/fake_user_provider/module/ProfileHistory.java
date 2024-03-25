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


@Table(name = "person.profile_history")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileHistory {
    @Id
    private UUID id;
    private Timestamp created;
    private UUID profileId;
    private String profileType;
    private String reason;
    private String comment;
    private String changedValues;
    @Transient
    private User user;
}
