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

@Table(name = "person.merchant_members_invitations")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MerchantMemberInvitation {
    @Id
    private UUID id;
    private Timestamp created;
    private Timestamp expires;
    private UUID merchantId;
    private String firstName;
    private String lastName;
    private String email;
    private String status;
    @Transient
    private Merchant merchant;
}
