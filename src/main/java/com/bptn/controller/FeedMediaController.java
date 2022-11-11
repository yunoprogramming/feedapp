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
import com.bptn.service.FeedMediaService;

@RestController
public class FeedMediaController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FeedMediaService feedMediaService;

    @PostMapping(value = "/images/create")
    public ResponseEntity<?> createNewImage(@RequestBody ImageMetaData image) {

        logger.debug("Creating New Image: {}", image);

        ImageMetaData images = this.feedMediaService.createNewImage(image);

        return new ResponseEntity<>(images, HttpStatus.OK);

    }

    @GetMapping("/images/ImageMetaData/{postKey}")
    public Optional<ImageMetaData> getImageMediaByPostKey(@PathVariable("post") Post postKey) {

        logger.debug("Executing getImageMediaByPostKey API");

        Optional<ImageMetaData> images = this.feedMediaService.getImageMediaByPostKey(postKey);

        return images;
    }

    @GetMapping("/images/imageId/{imageId}")
    public Optional<ImageMetaData> getPostsImageMediByImageId(@PathVariable("imageID") String imageId) {

        logger.debug("Executing getPostsImageMediByImageId API");

        Optional<ImageMetaData> images = this.feedMediaService.getPostsImageMediaByImageID(imageId);

        return images;
    }

}
