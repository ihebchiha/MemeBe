package com.gobeyond.memebe.service;

import com.gobeyond.memebe.domain.dto.UserDto;
import com.gobeyond.memebe.domain.dto.request.RegistrationRequest;

public interface AccountService {
    UserDto registerUser(RegistrationRequest request);
}
