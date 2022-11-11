package com.bptn.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"History\"")
public class History {

    @Id
    @Column(name = "\"postID\"")
    String postID;

    @Column(name = "\"postType\"")
    String postType;

    @Column(name = "\"postUpload\"")
    String postUpload;

    @Column(name = "date")
    String date;

    @Column(name = "\"usernameKey\"")
    String usernameKey;


    public History() {
        super();
    }

    public History(String postID, String postType, String postUpload, String date, String usernameKey) {
        this.postID = postID;
        this.postType = postType;
        this.postUpload = postUpload;
        this.date = date;
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

    public String getPostUpload() {
        return postUpload;
    }

    public void setPostUpload(String postUpload) {
        this.postUpload = postUpload;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsernameKey() {
        return usernameKey;
    }

    public void setUsernameKey(String usernameKey) {
        this.usernameKey = usernameKey;
    }

    @Override
    public String toString() {
        return "History [postID=" + postID + ", postType=" + postType + ", postUpload=" + postUpload + ", date=" + date
                + "]";
    }

}
