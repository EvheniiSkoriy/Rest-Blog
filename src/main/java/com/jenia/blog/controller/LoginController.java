package com.jenia.blog.controller;

import com.jenia.blog.model.User;
import com.jenia.blog.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RestController
public class LoginController {

    private final ServiceUser serviceUser;

    @Autowired
    public LoginController(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

//
//    @PostMapping("/login")
//    public String show(@RequestParam(name = "username") String username,@RequestParam(name ="password") String password){
//        Optional<User> user = serviceUser.findByUsername(username);
//        if(user!=null && user.get().getPassword().equals(password)){
//            return "Successful login";
//        }
//        return "Incorrect data";
//    }

    @PostMapping("/login")
    public String show(@RequestBody User user2){
        Optional<User> user = serviceUser.findByUsername(user2.getUsername());
        if(user!=null && user.get().getPassword().equals(user2.getPassword())){
            return "Successful login";
        }
        return "Incorrect data";
    }

}
