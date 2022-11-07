package com.bptn.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "\"Post\"")
public class Post {

    @Id
    @Column(name = "\"postID\"")
    String postID;

    @Column(name = "\"postType\"")
    String postType;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "\"usernameKey\"")
    public UserID userId;

    public Post() {
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public UserID getUserId() {
        return this.userId;
    }

    public void setUserId(UserID userId) {
        this.userId = userId;
    }

}
