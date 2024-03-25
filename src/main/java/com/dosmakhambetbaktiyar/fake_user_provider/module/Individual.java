package com.dosmakhambetbaktiyar.fake_user_provider.module;

import java.util.UUID;
import java.sql.Timestamp;

import com.enums.IndividualStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "person.individuals")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private IndividualStatus status;
    @Transient
    private User user;
}
