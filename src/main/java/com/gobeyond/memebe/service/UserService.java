package com.gobeyond.memebe.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserService extends UserDetails {
    UserDetails getUserByUsername(String username);
}
