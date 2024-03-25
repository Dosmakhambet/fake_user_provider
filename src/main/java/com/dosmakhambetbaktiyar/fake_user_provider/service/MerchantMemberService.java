package com.dosmakhambetbaktiyar.fake_user_provider.service;

import com.dosmakhambetbaktiyar.fake_user_provider.module.MerchantMember;
import com.dosmakhambetbaktiyar.fake_user_provider.module.MerchantMemberInvitation;
import com.dosmakhambetbaktiyar.fake_user_provider.module.User;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface MerchantMemberService extends BaseService<MerchantMember, UUID>{
    Mono<MerchantMember> save(MerchantMemberInvitation invitation);

    Mono<MerchantMember> saveIndividual(UUID individualId, User user);
}
