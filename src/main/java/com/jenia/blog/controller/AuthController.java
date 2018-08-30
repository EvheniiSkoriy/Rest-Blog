package com.jenia.blog.controller;

import com.jenia.blog.dto.UserDTO;
import com.jenia.blog.model.User;
import com.jenia.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final UserRepository userRepository;

    @Autowired
    public AuthController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register/{username}")
    public UserDTO createUser(

            @PathVariable("username")
            final String username
    ) {
        final User user = generateUser(username);
        final User savedUser = userRepository.save(user);
        return new UserDTO(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getPassword(),
                "I show password for simplicity, use combination login/pass for basic auth in postman"
        );
    }

    private User generateUser(final String username) {
        return new User(
                username,
                "lastName",
                "pass123",
                "12345@gmail.com"
        );
    }
}
