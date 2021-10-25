package com.gobeyond.memebe.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }

}
