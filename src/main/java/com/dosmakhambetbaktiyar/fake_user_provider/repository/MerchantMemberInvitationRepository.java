package com.dosmakhambetbaktiyar.fake_user_provider.repository;

import com.dosmakhambetbaktiyar.fake_user_provider.module.MerchantMemberInvitation;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface MerchantMemberInvitationRepository extends ReactiveCrudRepository<MerchantMemberInvitation, UUID> {
    @Query("SELECT * FROM person.merchant_members_invitations  WHERE merchant_id = :merchantId OFFSET :offset LIMIT :limit")
    Flux<MerchantMemberInvitation> findAllByMerchantId(UUID merchantId, long offset, int limit);

    @Query("SELECT * FROM person.merchant_members_invitations OFFSET :offset LIMIT :limit")
    Flux<MerchantMemberInvitation> findAll(long offset, int limit);
}
