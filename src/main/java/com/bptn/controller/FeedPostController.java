package com.bptn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bptn.exceptions.InvalidRequestException;
import com.bptn.exceptions.InvalidUserNameException;
import com.bptn.jpa.Post;
import com.bptn.service.FeedPostService;
import com.bptn.service.UserService;
import com.bptn.request.FeedPostRequest;

@RestController
public class FeedPostController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FeedPostService feedPostService;

    @Autowired
    UserService userService;

    @PostMapping("/posts/feed/create")
    public ResponseEntity<?> saveFeed(@RequestBody FeedPostRequest request) {

        logger.debug("Executing saveFeed API");

        try {
            this.validateRequest(request);

            this.userService.validateUserId(request.getUsername());

            Post feed = this.feedPostService.getPostFormNewsAndSavePost(request);

            logger.debug("Post saved successfully");

            return new ResponseEntity<>(feed, HttpStatus.OK);

        } catch (InvalidRequestException | InvalidUserNameException e) {

            logger.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    private void validateRequest(FeedPostRequest request) throws InvalidRequestException {

        if (!StringUtils.hasText(request.getFromDate()) || !StringUtils.hasText(request.getToDate())) {
            throw new InvalidRequestException("Invalid Request: fromDate and toDate are required");
        }
    }
}
