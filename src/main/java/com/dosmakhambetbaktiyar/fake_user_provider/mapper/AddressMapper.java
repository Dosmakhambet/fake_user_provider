package com.dosmakhambetbaktiyar.fake_user_provider.mapper;


import com.dto.AddressDto;
import com.dosmakhambetbaktiyar.fake_user_provider.module.Address;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDto toDto(Address address);

    @InheritInverseConfiguration
    Address toEntity(AddressDto addressDto);

}
