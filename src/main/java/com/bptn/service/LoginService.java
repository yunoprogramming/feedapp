package com.bptn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bptn.jpa.Post;
import com.bptn.jpa.UserID;
import com.bptn.repository.LoginRepository;

@Service
public class LoginService {

    // Dependency injection
    @Autowired
    LoginRepository loginRepository;

    public String validateUserCredentials(UserID userParam) {

        String message = null;

        Optional<UserID> opt = this.loginRepository.findById(userParam.getUsername());

        if (opt.isPresent()) {
            if (opt.get().getUserPassword().equals(userParam.getUserPassword())) {
                message = "Login Successful";
            } else {
                message = "Incorrect Password";
            }
        } else {
            message = "User doesn't exist";
        }

        return message;
    }

    public List<Post> getPostsByUsername(String username) {

        Optional<UserID> opt = this.loginRepository.findById(username);

        return opt.orElse(null).getPosts();
    }
}
