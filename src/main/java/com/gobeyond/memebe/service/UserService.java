package com.gobeyond.memebe.memebe.service;

import com.gobeyond.memebe.domain.dto.UserDto;

public interface UserService {

    UserDto getUserByUsername(String username);
}
