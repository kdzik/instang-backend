package com.krystiandzik.instangserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long likeId;

    @ManyToOne
    @JsonIgnore
    private Photo photo;

    private Long photoId;

    private Long userId;

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public Long getLikeId() {
        return likeId;
    }

    public void setLikeId(Long likeId) {
        this.likeId = likeId;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Likes{" +
                "likeId=" + likeId +
                ", photo=" + photo +
                ", photoId=" + photoId +
                ", userId=" + userId +
                '}';
    }
}
