package com.gobeyond.memebe.service;

import com.gobeyond.memebe.domain.dto.request.RegistrationRequest;
import com.gobeyond.memebe.domain.dto.response.RegistrationResponse;

public interface AccountService {
    RegistrationResponse registerUser(RegistrationRequest request);
}
