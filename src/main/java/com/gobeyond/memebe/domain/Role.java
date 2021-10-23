package com.gobeyond.memebe.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.gobeyond.memebe.enumeration.UserRole;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_tole")
public class Role {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "id", strategy = "uuid2")
    private String id;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToOne(mappedBy = "id_user")
    private User user;

}
