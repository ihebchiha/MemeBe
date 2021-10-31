package com.gobeyond.memebe.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

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

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    Date creationDate;

    @NotBlank
    String role;

}