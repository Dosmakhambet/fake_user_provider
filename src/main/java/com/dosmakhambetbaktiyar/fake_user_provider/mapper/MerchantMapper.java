package com.dosmakhambetbaktiyar.fake_user_provider.mapper;

import com.dto.MerchantDto;
import com.dosmakhambetbaktiyar.fake_user_provider.module.Merchant;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MerchantMapper {
    MerchantDto toDto(Merchant merchant);
    @InheritInverseConfiguration
    Merchant toEntity(MerchantDto merchantDto);
}
