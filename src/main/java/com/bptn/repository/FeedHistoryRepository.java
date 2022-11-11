package com.bptn.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bptn.jpa.History;

public interface FeedHistoryRepository extends JpaRepository<History, String> {
    
    List<History> findByusernameKey(String username);

    List<History> findByPostID(String postID) ;

    List<History> findByPostType(String postType);

    @Transactional
    List<History> deleteByPostType(String postType);
}
