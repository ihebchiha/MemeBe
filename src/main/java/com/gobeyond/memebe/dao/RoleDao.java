package com.gobeyond.memebe.dao;

import com.gobeyond.memebe.domain.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, String> {

    Role findRoleByName(String role);
}
