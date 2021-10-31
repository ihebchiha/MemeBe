package com.gobeyond.memebe.service;

import com.gobeyond.memebe.domain.dto.request.RegistrationRequest;
import com.gobeyond.memebe.domain.dto.response.RegistrationResponse;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService extends UserDetails {
    UserDetails getUserByUsername(String username);
}
