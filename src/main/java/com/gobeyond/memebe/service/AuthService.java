package com.gobeyond.memebe.service;

import com.gobeyond.memebe.domain.dto.TokenDto;
import com.gobeyond.memebe.domain.dto.request.LoginRequest;

public interface AuthService {

    TokenDto authenticateUser(LoginRequest LoginRquest);
}