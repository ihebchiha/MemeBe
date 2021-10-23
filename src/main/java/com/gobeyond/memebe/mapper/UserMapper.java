package com.gobeyond.memebe.mapper;

import com.gobeyond.memebe.domain.User;
import com.gobeyond.memebe.domain.dto.UserDto;

import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDto toDto(User user);

    User toEntity(UserDto addressDto);
}
