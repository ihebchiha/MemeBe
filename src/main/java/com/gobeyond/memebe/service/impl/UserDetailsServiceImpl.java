package com.gobeyond.memebe.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.gobeyond.memebe.dao.RoleDao;
import com.gobeyond.memebe.dao.UserDao;
import com.gobeyond.memebe.domain.User;
import com.gobeyond.memebe.domain.dto.RoleDto;
import com.gobeyond.memebe.domain.dto.UserDetailsImpl;
import com.gobeyond.memebe.domain.dto.UserDto;
import com.gobeyond.memebe.domain.dto.request.RegistrationRequest;
import com.gobeyond.memebe.enumeration.UserRole;
import com.gobeyond.memebe.exception.BusinessException;
import com.gobeyond.memebe.exception.ResourceNotFoundException;
import com.gobeyond.memebe.mapper.UserMapper;
import com.gobeyond.memebe.service.UserService;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserService {

    private final RoleDao roleDao;

    private final UserDao userDao;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    public UserDetailsServiceImpl(RoleDao roleDao, UserDao userDao, UserMapper userMapper,
            PasswordEncoder passwordEncoder) {
        this.roleDao = roleDao;
        this.userDao = userDao;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails getUserByUsername(String username) {
        User user = userDao.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }

    @Override
    public UserDto registerUser(RegistrationRequest request) {
        if (userDao.existsByUsername(request.getUsername())) {
            throw new ResourceNotFoundException(101, "This username exists in our system");
        }

        if (userDao.existsByEmail(request.getEmail())) {
            throw new ResourceNotFoundException(102, "This email exists in our system");
        }

        // Create new user's account
        UserDto userDto = UserDto.builder().build();

        List<UserRole> roles = Arrays.asList(UserRole.values());

        // Checking if passed role exists
        boolean isRoleFound = roles.stream().anyMatch(role -> role.equals(request.getRole()));

        if (!isRoleFound) {
            throw new BusinessException(102, "Role requested is not allowed in our system");
        } else {
            userDto.setEmail(request.getEmail());
            userDto.setUsername(request.getUsername());
            userDto.setPassword(passwordEncoder.encode(request.getPassword()));
            userDto.setRole(RoleDto.builder().role(request.getRole()).build());
        }

        User user = userDao.save(userMapper.toEntity(userDto));

        if (user == null) {
            throw new BusinessException(103, "Registration failed");
        }

        return userMapper.toDto(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
