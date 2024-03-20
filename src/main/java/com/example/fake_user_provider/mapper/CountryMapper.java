package com.example.fake_user_provider.mapper;

import com.dto.CountryDto;
import com.example.fake_user_provider.module.Country;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryDto toDto(Country country);
    @InheritInverseConfiguration
    Country toEntity(CountryDto countryDto);
}
