package com.jenia.blog.controller;

import com.jenia.blog.model.Post;
import com.jenia.blog.service.ServicePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    private final ServicePost servicePost;

    @Autowired
    public HomeController(ServicePost servicePost) {
        this.servicePost = servicePost;
    }

    @GetMapping("/home")
    public List<Post> home() {
        
        return servicePost.findAllPosts();
    }
}
