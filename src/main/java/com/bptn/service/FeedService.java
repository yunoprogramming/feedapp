package com.bptn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bptn.jpa.Post;
import com.bptn.jpa.UserID;
import com.bptn.repository.FeedRepository;

@Service
public class FeedService {

    @Autowired
    FeedRepository feedRepository;

    public List<Post> getPostsByUsername(String username) {
        List<Post> posts = this.feedRepository.findByUserId(new UserID(username));

        posts = this.removeEmptyPosts(posts);

        return posts;
    }

    public List<Post> getPostsByPostID(String postID) {
        List<Post> posts = this.feedRepository.findByPostID(postID);

        posts = this.removeEmptyPosts(posts);

        return posts;
    }

    public List<Post> getPostsbyPostType(String postType) {
        List<Post> posts = this.feedRepository.findByPostType(postType);

        posts = this.removeEmptyPosts(posts);

        return posts;
    }

    List<Post> removeEmptyPosts(List<Post> posts) {

        posts.removeIf(p -> p.getPostType() == null || p.getPostType().isEmpty());

        return posts;
    }
}
