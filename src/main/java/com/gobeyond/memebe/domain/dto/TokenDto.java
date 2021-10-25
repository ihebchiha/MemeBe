package com.gobeyond.memebe.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenDto {

    private String authType;
    private String accessToken;
    private String role;
}