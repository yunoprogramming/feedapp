package com.bptn.service;

import java.util.Objects;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bptn.jpa.Post;
import com.bptn.jpa.UserID;
import com.bptn.repository.FeedPostRepository;
import com.bptn.request.FeedPostRequest;

@Service
public class FeedPostService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${api.key}")
    String apiKey;

    @Value("${api.base.url}")
    String apiBaseUrl;

    @Autowired
    FeedPostRepository feedPostRepository;

    @Autowired
    RestTemplate restTemplate;

    public Post getPostFormNewsAndSavePost(FeedPostRequest request) {

        String url = this.buildAPIUrl(request);

        String feedResult = getFeedFromNewsAPI(url);

        Post feed = storeFeed(feedResult, request);

        return feed;
    }

    public String buildAPIUrl(FeedPostRequest request) {

        StringBuilder urlBuilder = new StringBuilder();

        urlBuilder.append(apiBaseUrl).append("?q=").append(request.getQueryKeyword());

        if (request.getFromDate() != null && !request.getFromDate().isEmpty()) {
            urlBuilder.append("&from=").append(request.getFromDate());
        }

        if (request.getToDate() != null && !request.getToDate().isEmpty()) {
            urlBuilder.append("&to=").append(request.getToDate());
        }

        urlBuilder.append("&apiKey=").append(apiKey);
        logger.debug(urlBuilder.toString());
        return urlBuilder.toString();

    }

    public String getFeedFromNewsAPI(String url) {

        String result = this.restTemplate.getForObject(url, String.class);

        return result;
    }

    public Post storeFeed(String feedResult, FeedPostRequest request) {

        UserID userId = new UserID(request.getUsername());

        Post feed = new Post();

        feed.setPostType(feedResult);
        feed.setPostType(feedResult);
        feed.setUserId(userId);
        feed.setPostID(this.generatePostId(request));

        logger.debug("Feed to be stored: {}", feed);

        return this.feedPostRepository.save(feed);
    }

    public String generatePostId(FeedPostRequest request) {

        Random random = new Random(System.currentTimeMillis());

        StringBuilder postIdBuilder = new StringBuilder();

        postIdBuilder.append(random.nextInt());
        postIdBuilder.append(Objects.hashCode(request.getUsername() + " " + request.getQueryKeyword()));

        String postId = postIdBuilder.toString();

        if (postId.startsWith("-")) {
            postId = postId.substring(1);
        }

        return postId;
    }
}
