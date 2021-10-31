package com.gobeyond.memebe.service;

import com.gobeyond.memebe.domain.Role;
import com.gobeyond.memebe.domain.dto.RoleDto;

public interface RoleService {

    Role getRoleByUserId(String userID);

    Role saveRole(RoleDto roleDto);
}
