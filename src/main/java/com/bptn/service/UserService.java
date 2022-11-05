package com.bptn.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bptn.jpa.UserID;
import com.bptn.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String validateUserId(String username) {

        String message = null;

        Optional<UserID> opt = this.userRepository.findByUsername(username);

        if (opt.isPresent()) {
            if (opt.get().getUsername().equals(username)) {
                message = "Login Successful";
            } else {
                message = "Incorrect username";
            }
        } else {
            message = "User doesn't exist";
        }

        return message;

    }
}
