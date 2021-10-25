package com.gobeyond.memebe.domain.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationRequest {

    String email;
    String username;
    String password;
    String creationDate;
    String role;

}