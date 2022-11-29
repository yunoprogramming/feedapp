package com.bptn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bptn.jpa.UserID;
import com.bptn.service.UserService;

public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @GetMapping(value = "/users")
    public List<UserID> listUsers() {

        logger.debug("Listing Users!");

        List<UserID> users = null;

        return users;
    }

    @GetMapping(value = "/users/{username}")
    public UserID findUser(@PathVariable String username) {

        logger.debug("Finding User, username: {}");

        UserID user = null;

        return user;
    }

    @PostMapping(value = "/users/create")
    public String createUser(@RequestBody UserID user) {

        logger.debug("Creating User: {}", user);

        // this.userService.createUser(user);

        return "User Created Successfully";
    }

}
