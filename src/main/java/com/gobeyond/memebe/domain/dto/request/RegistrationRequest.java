package com.gobeyond.memebe.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {

    @Email
    String email;

    @NotBlank
    String username;

    @NotBlank
    String password;

    @NotBlank
    String role;

}