package com.bptn.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bptn.jpa.ImageMetaData;
import com.bptn.jpa.Post;
import com.bptn.request.FeedMediaRequest;
import com.bptn.service.FeedMediaService;

@RestController
public class FeedMediaController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FeedMediaService feedMediaService;

    @PostMapping(value = "/images/create")
    public ResponseEntity<?> createNewImage(@RequestBody FeedMediaRequest request) {

        logger.debug("Creating New Image: {}");

        ImageMetaData images = this.feedMediaService.createNewImage(request);

        return new ResponseEntity<>(images, HttpStatus.OK);

    }

    @GetMapping("/images/postKey/{postKey}")
    public Optional<ImageMetaData> getImageMediaByPostKey(@PathVariable("postKey") Post post) {

        logger.debug("Executing getImageMediaByPostKey API");

        Optional<ImageMetaData> images = this.feedMediaService.getImageMediaByPostKey(post);

        return images;
    }

    @GetMapping("/images/imageId/{imageID}")
    public Optional<ImageMetaData> getPostsImageMediaByImageID(@PathVariable("imageID") String imageId) {

        logger.debug("Executing getPostsImageMediaByImageID API");

        Optional<ImageMetaData> images = this.feedMediaService.getPostsImageMediaByImageID(imageId);

        return images;
    }

}
