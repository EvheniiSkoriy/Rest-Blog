package com.jenia.blog.service;

import com.jenia.blog.model.User;

import java.util.List;
import java.util.Optional;

public interface ServiceUser {

    List<User> getAllUsers();

    User save(User user);

    Optional<User> findByUsername(String username);
}
