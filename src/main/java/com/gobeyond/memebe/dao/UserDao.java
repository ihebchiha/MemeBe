package com.gobeyond.memebe.dao;

import java.util.Optional;

import com.gobeyond.memebe.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, String> {
    Optional<User> findUserByUsername(String name);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
