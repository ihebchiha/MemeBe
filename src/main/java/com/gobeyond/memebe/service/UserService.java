package com.gobeyond.memebe.service;

import com.gobeyond.memebe.domain.dto.UserDto;
import com.gobeyond.memebe.domain.dto.request.RegistrationRequest;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserService extends UserDetails {

    UserDetails getUserByUsername(String username);

    UserDto registerUser(RegistrationRequest request);

}
