package com.bptn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bptn.jpa.History;
import com.bptn.service.FeedHistoryService;

@RestController
public class FeedHistoryController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FeedHistoryService feedHistoryService;

    @GetMapping("/history/username/{username}")
    public List<History> getPostsByUsername(@PathVariable("username") String username) {

        logger.debug("Executing getPostsByUsername API");

        List<History> posts = this.feedHistoryService.getPostsByUsername(username);

        return posts;
    }

    @GetMapping("/history/postID/{postID}")
    public List<History> getPostsByPostId(@PathVariable("postID") String postID) {

        logger.debug("Executing getPostsByPostID API");

        List<History> posts = this.feedHistoryService.getPostsByPostId(postID);

        return posts;
    }

    @GetMapping("/history/postType/{postType}")
    public List<History> getPostByPostType(@PathVariable("postType") String postType) {

        logger.debug("Executing getPostByPostType API");

        List<History> posts = this.feedHistoryService.getPostsByPostType(postType);

        return posts;
    }

    @DeleteMapping("/history/delete/postType/{postType}")
    public List<History> deleteHistoryByPostType(@PathVariable("postType") List<History> postType) {

        logger.debug("Executing deleteHistoryByPostType API");

        List<History> posts = this.feedHistoryService.deleteHistoryByPostType(postType);

        return posts;
    }

}
