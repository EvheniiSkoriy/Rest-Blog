package com.jenia.blog.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Entity
@Table(name = "POST")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_post")
    private int id;

    @Column(name = "title")
    @Length(min=1,message = "Must have at least 1 character")
    private String title;

    @Column(name = "body")
    private String body;

    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName="user_id",nullable=false)
    @NotNull
    private User user;

}
