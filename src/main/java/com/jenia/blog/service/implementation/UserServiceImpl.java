package com.jenia.blog.service.implementation;

import com.jenia.blog.model.User;
import com.jenia.blog.repository.RepositoryRole;
import com.jenia.blog.repository.RepositoryUser;
import com.jenia.blog.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements ServiceUser {

    private final RepositoryUser userRepository;
    private final RepositoryRole repositoryRole;
    @Autowired
    public UserServiceImpl(RepositoryUser userRepository, RepositoryRole repositoryRole) {
        this.userRepository = userRepository;
        this.repositoryRole = repositoryRole;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public Optional<User> findByUsername(String username) {
        return  userRepository.findByUsername(username);
    }

    @Override
    public User save(User user) {

        return userRepository.save(user);
    }
}
