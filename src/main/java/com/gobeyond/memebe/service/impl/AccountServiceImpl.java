package com.gobeyond.memebe.service.impl;

import com.gobeyond.memebe.dao.UserDao;
import com.gobeyond.memebe.domain.User;
import com.gobeyond.memebe.domain.dto.RoleDto;
import com.gobeyond.memebe.domain.dto.UserDto;
import com.gobeyond.memebe.domain.dto.request.RegistrationRequest;
import com.gobeyond.memebe.domain.dto.response.RegistrationResponse;
import com.gobeyond.memebe.enumeration.Rank;
import com.gobeyond.memebe.enumeration.UserRole;
import com.gobeyond.memebe.exception.BusinessException;
import com.gobeyond.memebe.exception.ResourceNotFoundException;
import com.gobeyond.memebe.mapper.UserMapper;
import com.gobeyond.memebe.service.AccountService;
import com.gobeyond.memebe.service.RoleService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final UserDao userDao;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    private final RoleService roleService;

    public AccountServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder, UserMapper userMapper, RoleService roleService) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.roleService = roleService;
    }

    @Override
    public RegistrationResponse registerUser(RegistrationRequest request) {
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
        boolean isRoleFound = roles.stream().anyMatch(role -> role.name().equals(request.getRole()));

        if (!isRoleFound) {
            throw new BusinessException(102, "Role requested is not allowed in our system");
        } else {
            userDto.setEmail(request.getEmail());
            userDto.setUsername(request.getUsername());
            userDto.setPassword(passwordEncoder.encode(request.getPassword()));
            userDto.setRole(RoleDto.builder().role(request.getRole()).build());
            userDto.setCreationDate(request.getCreationDate());
            userDto.setRank(Rank.ROOKIE);
            userDto.setPoints(0L);
        }

        User savedUser =userDao.save(userMapper.toEntity(userDto));


        return RegistrationResponse
                .builder()
                .email(userDto.getEmail())
                .username(userDto.getUsername())
                .role(userDto.getRole())
                .build();
    }
}
