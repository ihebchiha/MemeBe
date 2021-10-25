package com.gobeyond.memebe.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private RoleDto role;
    private String email;
    private String username;
    private String password;
}