package com.dosmakhambetbaktiyar.fake_user_provider.mapper;

import com.dto.ProfileHistoryDto;
import com.dosmakhambetbaktiyar.fake_user_provider.module.ProfileHistory;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileHistoryMapper {
    ProfileHistoryDto toDto(ProfileHistory profileHistory);
    @InheritInverseConfiguration
    ProfileHistory toEntity(ProfileHistoryDto profileHistoryDto);
}
