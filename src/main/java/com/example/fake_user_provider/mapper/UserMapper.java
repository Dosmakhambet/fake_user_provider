package com.example.fake_user_provider.mapper;

import com.dto.UserDto;
import com.example.fake_user_provider.module.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    @InheritInverseConfiguration
    User toEntity(UserDto userDto);
}
