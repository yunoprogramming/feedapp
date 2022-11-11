package com.bptn.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import com.bptn.jpa.ImageMetaData;
import com.bptn.jpa.Post;
import com.bptn.repository.FeedImageMetaDataRepository;
import com.bptn.request.FeedMediaRequest;

@Service
public class FeedMediaService {

    @Autowired
    FeedImageMetaDataRepository feedImageMetaDataRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Optional<ImageMetaData> getImageMediaByPostKey(Post post) {

        Optional<ImageMetaData> images = this.feedImageMetaDataRepository.findByPost(post);

        return images;
    }

    public Optional<ImageMetaData> getPostsImageMediaByImageID(String imageID) {

        Optional<ImageMetaData> images = this.feedImageMetaDataRepository.findByImageID(imageID);

        return images;
    }

    public ImageMetaData createNewImage(FeedMediaRequest request) {

        Post postKey = new Post(request.getPostKey());

        ImageMetaData imd = new ImageMetaData();

        imd.setImageID(request.getImageId());
        imd.setImageDate(request.getImageDate());
        imd.setImageFormat(request.getImageFormat());
        imd.setImageName(request.getImageName());
        imd.setImageSize(request.getImageSize());
        imd.setResolution(request.getResolution());
        imd.setPost(postKey);

        return this.feedImageMetaDataRepository.save(imd);

    }

}

// remove posts

// List<Post> removeEmptyImages(List<Post> posts) {

// posts.removeIf(p -> p.getPostType() == null || p.getPostType().isEmpty());

// return posts;
// }

// insert image with JDBC

// public ImageMetaData createNewImage(FeedMediaRequest request) {

// String sql = "INSERT INTO
// \"ImageMetaData\"(imageID,imageName,\"imageSize\",\"imageFormat\",\"imageDate\",\"resolution\")
// "
// + "VALUES(?,?,?,?,?,?)";

// logger.debug("Image Created: {}");

// jdbcTemplate.update(sql, new Object[] { request.getImageId(),
// request.getImageName(),
// request.getImageSize(), request.getImageSize(), request.getImageFormat(),
// request.getImageDate(),
// request.getResolution() });
// return null;

// }
