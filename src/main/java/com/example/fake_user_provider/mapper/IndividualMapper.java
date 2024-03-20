package com.example.fake_user_provider.mapper;

import com.dto.IndividualDto;
import com.example.fake_user_provider.module.Individual;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IndividualMapper {
    IndividualDto toDto(Individual individual);
    @InheritInverseConfiguration
    Individual toEntity(IndividualDto individual);
}
