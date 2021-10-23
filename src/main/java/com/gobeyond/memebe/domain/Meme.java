package com.gobeyond.memebe.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "t_meme")
public class Meme {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "", strategy = "")
    private String id;

    @URL
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
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
