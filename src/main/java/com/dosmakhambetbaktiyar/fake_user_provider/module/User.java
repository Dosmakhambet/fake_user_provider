package com.dosmakhambetbaktiyar.fake_user_provider.module;

import java.util.UUID;
import java.sql.Timestamp;

import com.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "person.users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private UserStatus status;
    private boolean filled;
    private UUID addressId;
    @Transient
    private Address address;
}
