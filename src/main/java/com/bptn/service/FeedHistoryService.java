package com.bptn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bptn.jpa.History;
import com.bptn.repository.FeedHistoryRepository;

@Service
public class FeedHistoryService {

    @Autowired
    UserService userService;

    @Autowired
    FeedHistoryRepository feedHistoryRepository;

    public List<History> getPostsByUsername(String username) {

        List<History> posts = this.feedHistoryRepository.findByusernameKey(username);

        posts = this.deleteHistoryByPostType(posts);

        return posts;
    }

    public List<History> getPostsByPostId(String postID) {

        List<History> posts = this.feedHistoryRepository.findByPostID(postID);

        posts = this.deleteHistoryByPostType(posts);

        return posts;
    }

    public List<History> getPostsByPostType(String postType) {

        List<History> posts = this.feedHistoryRepository.findByPostType(postType);

        posts = this.deleteHistoryByPostType(posts);

        return posts;
    }

    public List<History> deleteHistoryByPostType(List<History> posts) {

        posts.removeIf(p -> p.getPostType() == null || p.getPostType().isEmpty());

        return posts;
    }

    List<History> removeEmptyHistory(List<History> posts) {

        posts.removeIf(p -> p.getPostType().isEmpty());

        return posts;

    }

}
