package com.bptn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bptn.jpa.ImageMetaData;
import com.bptn.service.FeedMediaService;

@RestController
public class FeedMediaController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FeedMediaService feedMediaService;

    @PostMapping(value = "/images/create")
    public ResponseEntity<?> createNewImage(@RequestBody ImageMetaData image) {

        logger.debug("Creating New Image: {}", image);

        return new ResponseEntity<>(image, HttpStatus.OK);

    }

}
