package com.example.fake_user_provider.module;

import java.util.UUID;
import java.sql.Timestamp;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "merchant_members")
@Data
@Builder
public class MerchantMember {
    @Id
    private UUID id;
    private UUID userId;
    private Timestamp created;
    private Timestamp updated;
    private UUID merchantId;

    private Merchant merchant;

    private String memberRole;
    private String status;
}
