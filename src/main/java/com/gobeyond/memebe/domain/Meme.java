package com.gobeyond.memebe.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.URL;

import java.util.UUID;

@Entity
@Table(name = "t_meme")
public class Meme {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(unique = true)
    private String id;

    @URL
    @NotBlank
    private String memeUrl;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    private Long rating;

    @NotNull
    private Long likes;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
}
