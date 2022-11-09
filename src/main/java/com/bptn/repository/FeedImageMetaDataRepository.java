package com.bptn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bptn.jpa.ImageMetaData;
import com.bptn.jpa.Post;

@Repository
public interface FeedImageMetaDataRepository extends JpaRepository<ImageMetaData, String> {

    Optional<ImageMetaData> findByImageID(String imageID);

    Optional<ImageMetaData> findByPost(String post);

}
