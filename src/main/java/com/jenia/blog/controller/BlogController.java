package com.jenia.blog.controller;

import com.jenia.blog.model.Post;
import com.jenia.blog.model.User;
import com.jenia.blog.service.ServicePost;
import com.jenia.blog.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogController {

    private final ServiceUser userService;

    private final ServicePost servicePost;

    @Autowired
    public BlogController(ServiceUser ServiceUser, ServicePost servicePost) {
        this.userService = ServiceUser;
        this.servicePost = servicePost;
    }

    @GetMapping("/blog/{username}/posts")
    public List<Post> blogForUsername(@PathVariable String username) {

        Optional<User> optionalUser = userService.findByUsername(username);

        if (optionalUser.isPresent()) {
            List<Post> posts = servicePost.findAllUserPosts(username);
            return posts;
        }
        return null;
    }
}
