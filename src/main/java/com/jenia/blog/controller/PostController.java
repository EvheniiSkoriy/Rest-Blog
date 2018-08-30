package com.jenia.blog.controller;

import com.jenia.blog.model.Post;
import com.jenia.blog.model.User;
import com.jenia.blog.service.ServicePost;
import com.jenia.blog.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class PostController {
    private final ServiceUser serviceUser;
    private final ServicePost servicePost;

    @Autowired
    public PostController(ServiceUser serviceUser, ServicePost servicePost) {
        this.serviceUser = serviceUser;
        this.servicePost = servicePost;
    }

    @PostMapping("/posts/newPost")
    public String createdNewPost(@Valid Post post,
                          BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "Post was not created";
        } else {
            servicePost.save(post);
            return "Post was created";
        }
    }

    @GetMapping("/posts/newPost")
    public Post newPost(Post post){
       Optional<User> user = serviceUser.findByUsername(post.getUser().getUsername());
        if (user.isPresent()) {
            post.setUser(user.get());
            return post;
        }else {
            return null;
        }
    }

    @PutMapping("/editPost/{id}")
    public Post editPostWithId(@PathVariable Integer id,User user){
        Optional<Post> optionalPost = servicePost.findById(id);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();

            if (user.getUsername().equals(post.getUser().getUsername())) {

                return post;
            }
        } else {
            return null;
        }
        return null;
    }

    @GetMapping("/posts/{id}")
    public Post getPostWithId(@PathVariable Integer id) {

        Optional<Post> optionalPost = servicePost.findById(id);
        if(optionalPost.isPresent()){
            return  optionalPost.get();
        }
           return null;
    }

    @DeleteMapping("/post/{id}")
    public String deletePost(@PathVariable Integer id,
                             User user){

        Optional<Post> optionalPost = servicePost.findById(id);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();

            if (user.getUsername().equals(post.getUser().getUsername())) {
                servicePost.delete(post);
                return "Successful delete";
            }

        } else {
            return "Post not found";
        }
        return "Post not found";
    }


}
