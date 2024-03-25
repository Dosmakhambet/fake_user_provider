package com.dosmakhambetbaktiyar.fake_user_provider.repository;

import com.dosmakhambetbaktiyar.fake_user_provider.module.Merchant;
import com.dosmakhambetbaktiyar.fake_user_provider.module.MerchantMember;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface MerchantMemberRepository extends ReactiveCrudRepository<MerchantMember, UUID>{

    @Query("SELECT * FROM person.merchant_members WHERE merchant_id = :merchantId OFFSET :offset LIMIT :limit")
    Flux<MerchantMember> findAllByMerchantId(UUID merchantId, long offset, int limit);
}
