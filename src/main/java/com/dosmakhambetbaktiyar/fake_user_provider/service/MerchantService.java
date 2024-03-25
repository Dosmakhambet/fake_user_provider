package com.dosmakhambetbaktiyar.fake_user_provider.service;

import com.dosmakhambetbaktiyar.fake_user_provider.module.Merchant;
import com.dosmakhambetbaktiyar.fake_user_provider.module.MerchantMember;
import com.dosmakhambetbaktiyar.fake_user_provider.module.MerchantMemberInvitation;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface MerchantService extends BaseService<Merchant, UUID>{
    Flux<MerchantMemberInvitation> findAllInvitations(UUID merchantId, Pageable pageable);

    Flux<MerchantMember> findAllMembers(UUID merchantId, Pageable pageable);
}
