package com.gobeyond.memebe.domain.dto;

import com.fasterxml.jackson.databind.DatabindException;
import com.gobeyond.memebe.enumeration.Rank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private RoleDto role;
    private String email;
    private String username;
    private String password;
    private Date creationDate;
    private String rank;
    private Long points;
    private Boolean hasAccount;
}