package com.dosmakhambetbaktiyar.fake_user_provider.mapper;

import com.dosmakhambetbaktiyar.fake_user_provider.module.MerchantMemberInvitation;
import com.dto.RegisterIndividualDto;
import com.dto.RegisterMerchantMemberDto;
import com.dto.UserDto;
import com.dosmakhambetbaktiyar.fake_user_provider.module.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    @InheritInverseConfiguration
    User toEntity(UserDto userDto);

    User toEntity(RegisterIndividualDto registerDto);

    User toEntity(MerchantMemberInvitation invitation);

    User toEntity(RegisterMerchantMemberDto registerMerchantMemberDto);
}
