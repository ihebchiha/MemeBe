package com.gobeyond.memebe.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.gobeyond.memebe.domain.dto.TokenDto;
import com.gobeyond.memebe.domain.dto.UserDetailsImpl;
import com.gobeyond.memebe.domain.dto.request.LoginRequest;
import com.gobeyond.memebe.security.token.JwtUtils;
import com.gobeyond.memebe.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public TokenDto authenticateUser(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return TokenDto.builder().accessToken(jwt).authType(authentication.getName()).role(roles.get(0)).build();
    }

}