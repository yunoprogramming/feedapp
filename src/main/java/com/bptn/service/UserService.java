package com.bptn.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bptn.exceptions.InvalidUserNameException;
import com.bptn.jpa.UserID;
import com.bptn.repository.UserRepository;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserRepository userRepository;

    public void validateUserId(String username) throws InvalidUserNameException {

        Optional<UserID> opt = this.userRepository.findById(username);

        if (opt.isEmpty()) {
            logger.error("Username={} doesn't exist", username);

            throw new InvalidUserNameException("Username doesn't exist");
        } else {
            logger.debug("Username={} exists", username);
        }

    }
}
