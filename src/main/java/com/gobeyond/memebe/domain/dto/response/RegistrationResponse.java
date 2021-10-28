package com.gobeyond.memebe.domain.dto.response;

import com.gobeyond.memebe.domain.dto.RoleDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationResponse {
    private RoleDto role;
    private String email;
    private String username;
}
