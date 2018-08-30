package com.jenia.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="USER")
@JsonIgnoreProperties({"posts"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", unique = true)
    private int id;

    @Column(name = "username",unique = true)
    @NotEmpty(message="provide valid user name")
    private String username;

    @Column(name = "login")
    @NotEmpty(message="provide valid login")
    private String login;

    @Column(name = "lastname")
    @NotEmpty(message="provide valid last name")
    private String lastName;

    @Column(name = "password")
    @NotEmpty(message="provide valid password")
    @Length(min=5, message = "Your password must contain at least 5 chars")
    @JsonIgnore
    private String password;

    @Column(name = "email", unique = true)
    @Email(message="provide valid email")
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
    private Collection<Role> roles;

    @OneToMany(mappedBy="user")
    private Collection<Post> posts;

    @Column(name="active")
    private int active;




}
