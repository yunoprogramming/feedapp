package com.bptn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bptn.models.History;

public interface FeedHistoryRepository extends JpaRepository<History, String> {
    
    List<History> findByusernameKey(String username);

    List<History> findByPostID(String postID) ;

    List<History> findByPostType(String postType);

    @Transactional
    List<History> deleteByPostType(String postType);
}
