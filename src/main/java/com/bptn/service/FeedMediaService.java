package com.bptn.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import com.bptn.jpa.ImageMetaData;
import com.bptn.jpa.Post;
// import com.bptn.jpa.Post;
import com.bptn.repository.FeedImageMetaDataRepository;

@Service
public class FeedMediaService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FeedImageMetaDataRepository feedImageMetaDataRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Optional<ImageMetaData> getImageMediaByPostKey(String post) {

        Optional<ImageMetaData> images = this.feedImageMetaDataRepository.findByPost(new String(post));

        return images;
    }

    public Optional<ImageMetaData> getPostsImageMediaByImageID(String imageID) {

        Optional<ImageMetaData> images = this.feedImageMetaDataRepository.findByImageID(new String(imageID));

        return images;
    }

    // List<Post> removeEmptyImages(List<Post> posts) {

    // posts.removeIf(p -> p.getPostType() == null || p.getPostType().isEmpty());

    // return posts;
    // }

    public void createNewImage(ImageMetaData post) {

        String sql = "INSERT INTO \"ImageMetaData\"(imageID,imageName,\"imageSize\",\"imageFormat\",\"imageDate\",\"resolution\") "
                + "VALUES(?,?,?,?,?,?)";

        logger.debug("Image Created: {}", sql);

        jdbcTemplate.update(sql, new Object[] { post.getImageID(), post.getImageName(),
                post.getImageSize(), post.getImageSize(), post.getImageFormat(), post.getImageDate(),
                post.getResolution() });
    }

}
