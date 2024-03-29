package com.dosmakhambetbaktiyar.fake_user_provider.mapper;

import com.dto.IndividualDto;
import com.dosmakhambetbaktiyar.fake_user_provider.module.Individual;
import com.dto.RegisterIndividualDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IndividualMapper {
    IndividualDto toDto(Individual individual);
    @InheritInverseConfiguration
    Individual toEntity(IndividualDto individual);

    Individual toEntity(RegisterIndividualDto registerDto);
}
