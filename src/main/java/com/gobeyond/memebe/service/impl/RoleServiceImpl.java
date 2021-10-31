package com.gobeyond.memebe.service.impl;

import com.gobeyond.memebe.dao.RoleDao;
import com.gobeyond.memebe.domain.Role;
import com.gobeyond.memebe.domain.dto.RoleDto;
import com.gobeyond.memebe.exception.ResourceNotFoundException;
import com.gobeyond.memebe.mapper.RoleMapper;
import com.gobeyond.memebe.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleDao roleDao, RoleMapper roleMapper) {
        this.roleDao = roleDao;
        this.roleMapper = roleMapper;
    }

    @Override
    public Role getRoleByUserId(String userID) {
        Optional<Role> roleOptional = roleDao.findRoleByName(userID);
        return roleOptional.orElseThrow(() -> new ResourceNotFoundException(400, "Role not found"));
    }

    @Override
    public Role saveRole(RoleDto roleDto) {
        return roleDao.save(roleMapper.toEntity(roleDto));
    }
}
