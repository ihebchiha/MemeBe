package com.gobeyond.memebe.domain.dto;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto extends User {

    private String email;
    private String phoneNumber;
    private AddressDto addressDto;
    private List<RoleDto> roles;

    public UserDto(String email, String phoneNumber, AddressDto addressDto, String username, String password,
            boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
            Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);

        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addressDto = addressDto;
    }

}