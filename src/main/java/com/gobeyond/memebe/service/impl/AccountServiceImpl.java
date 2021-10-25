package com.gobeyond.memebe.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import com.gobeyond.memebe.dao.UserDao;
import com.gobeyond.memebe.domain.User;
import com.gobeyond.memebe.domain.dto.RoleDto;
import com.gobeyond.memebe.domain.dto.UserDto;
import com.gobeyond.memebe.domain.dto.request.RegistrationRequest;
import com.gobeyond.memebe.enumeration.UserRole;
import com.gobeyond.memebe.exception.BusinessException;
import com.gobeyond.memebe.exception.ResourceNotFoundException;
import com.gobeyond.memebe.mapper.UserMapper;
import com.gobeyond.memebe.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

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
}
