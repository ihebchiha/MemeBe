package com.gobeyond.memebe.domain;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.gobeyond.memebe.enumeration.Rank;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Data
@Entity
@Table(name = "t_account")
class Account {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(unique = true)
    private String id;

    @Pattern(regexp = "")
    @NotBlank
    @Size(max = 12)
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "Varchar(25) default Rookie")
    private Rank rank;

    @NotNull
    @Column(columnDefinition = "integer default 0")
    private Long points;

    @OneToMany(mappedBy = "id")
    private List<Meme> memes;

    @OneToOne(mappedBy = "account")
    private User user;

    @OneToOne(mappedBy = "account")
    private Address address;

    @OneToOne(mappedBy = "account")
    private Role role;
}
