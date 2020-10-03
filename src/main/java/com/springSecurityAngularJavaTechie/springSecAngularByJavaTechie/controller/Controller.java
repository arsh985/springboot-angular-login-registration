package com.springSecurityAngularJavaTechie.springSecAngularByJavaTechie.controller;

import com.springSecurityAngularJavaTechie.springSecAngularByJavaTechie.model.User;
import com.springSecurityAngularJavaTechie.springSecAngularByJavaTechie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import  org.springframework.beans.factory.annotation.Autowired;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Controller {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    public BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String addUser(@RequestBody User user){
        String pwd = user.getPassword();
        String encryptPwd = passwordEncoder.encode(pwd);
        user.setPassword(encryptPwd);
        userRepository.save(user);

        return user.getUsername()+" added Successfully.";
    }

    @GetMapping("/")
    public String login() {

        return ("<h1>Authenticated Successfully,,,,,,,Welcome</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }
}
