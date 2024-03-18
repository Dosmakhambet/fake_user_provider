package com.example.fake_user_provider.module;


import java.util.List;
import java.util.UUID;
import java.sql.Timestamp;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "merchants")
@Data
@Builder
public class Merchant {
    @Id
    private UUID id;
    private UUID creatorId;
    private Timestamp created;
    private Timestamp updated;
    private String companyName;
    private String companyId;
    private String email;
    private String phoneNumber;
    private Timestamp verifiedAt;
    private Timestamp archivedAt;
    private String status;
    private boolean filled;
    @Transient
    private List<MerchantMember> members;
    @Transient
    private User creator;
}
