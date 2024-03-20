package com.example.fake_user_provider.mapper;

import com.dto.MerchantMemberDto;
import com.example.fake_user_provider.module.MerchantMember;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MerchantMemberMapper {
    MerchantMemberDto toDto(MerchantMember merchantMember);
    @InheritInverseConfiguration
    MerchantMember toEntity(MerchantMemberDto merchantMemberDto);
}
