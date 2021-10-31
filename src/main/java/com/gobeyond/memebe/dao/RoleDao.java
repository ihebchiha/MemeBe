package com.gobeyond.memebe.dao;

import com.gobeyond.memebe.domain.Role;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleDao extends JpaRepository<Role, String> {

    Optional<Role> findRoleByName(String role);
}
