package com.dosmakhambetbaktiyar.fake_user_provider.mapper;

import com.dosmakhambetbaktiyar.fake_user_provider.module.MerchantMemberInvitation;
import com.dto.MerchantMemberInvitationDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MerchantMemberInvitationMapper {
    MerchantMemberInvitation toEntity(MerchantMemberInvitationDto dto);

    @InheritInverseConfiguration
    MerchantMemberInvitationDto toDto(MerchantMemberInvitation entity);
}
