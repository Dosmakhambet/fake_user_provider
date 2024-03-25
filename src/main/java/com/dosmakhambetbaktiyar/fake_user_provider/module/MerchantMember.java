package com.dosmakhambetbaktiyar.fake_user_provider.module;

import java.util.UUID;
import java.sql.Timestamp;

import com.enums.MerchantMemberStatus;
import com.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "person.merchant_members")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MerchantMember {
    @Id
    private UUID id;
    private UUID userId;
    private Timestamp created;
    private Timestamp updated;
    private UUID merchantId;
    private Role memberRole;
    private MerchantMemberStatus status;
    @Transient
    private Merchant merchant;
    @Transient
    private Individual individual;
    @Transient
    private User user;
}
