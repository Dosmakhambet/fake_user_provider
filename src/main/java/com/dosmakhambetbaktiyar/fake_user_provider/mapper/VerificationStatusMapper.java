package com.dosmakhambetbaktiyar.fake_user_provider.mapper;

import com.dto.VerificationStatusDto;
import com.dosmakhambetbaktiyar.fake_user_provider.module.VerificationStatus;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VerificationStatusMapper {
    VerificationStatusDto toDto(VerificationStatus verificationStatus);
    @InheritInverseConfiguration
    VerificationStatus toEntity(VerificationStatusDto verificationStatusDto);
}
