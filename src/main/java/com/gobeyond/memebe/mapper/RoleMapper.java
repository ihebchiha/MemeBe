package com.gobeyond.memebe.mapper;

import com.gobeyond.memebe.domain.Role;
import com.gobeyond.memebe.domain.dto.RoleDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    private final ModelMapper mapper;

    public RoleMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public RoleDto toDto(Role role) {
        return mapper.map(role, RoleDto.class);
    }

    public Role toEntity(RoleDto roleDto) {
        return mapper.map(roleDto, Role.class);
    }
}
