package com.gobeyond.memebe.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private RoleDto role;
    private String email;
    private String username;
    private String password;
    private LocalDateTime creationDate;
}