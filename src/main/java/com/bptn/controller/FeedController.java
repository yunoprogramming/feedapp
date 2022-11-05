package com.bptn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bptn.jpa.Post;
import com.bptn.service.FeedService;

@RestController
public class FeedController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FeedService feedService;

    @GetMapping("/posts/username/{username}")
    public List<Post> getPostsByUsername(@PathVariable("username") String username) {

        logger.debug("Executing getPostsByUsername API");

        List<Post> posts = this.feedService.getPostsByUsername(username);

        return posts;
    }

    @GetMapping("/posts/postId/{postID}")
    public List<Post> getPostsByPostID(@PathVariable("postID") String postID) {

        logger.debug("Executing getPostsByPostID API");

        List<Post> posts = this.feedService.getPostsByPostID(postID);

        return posts;
    }

    @GetMapping("/posts/postType/{postType}")
    public List<Post> getPostsbyPostType(@PathVariable("postType") String postType) {

        logger.debug("Executing getPostsbyPostType API");

        List<Post> posts = this.feedService.getPostsbyPostType(postType);

        return posts;
    }

}
