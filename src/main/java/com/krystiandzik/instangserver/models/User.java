package com.krystiandzik.instangserver.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    private Long avatarId;

    @CreationTimestamp
    private Date created;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Photo> photoList;

   // @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
  //  private List<Photo> likedPhotoList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Follow> followers;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Follow> followed;

    public Long getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(Long avatarId) {
        this.avatarId = avatarId;
    }

    public List<Follow> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Follow> followers) {
        this.followers = followers;
    }

    public List<Follow> getFollowed() {
        return followed;
    }

    public void setFollowed(List<Follow> followed) {
        this.followed = followed;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }

 /*   public List<Photo> getLikedPhotoList() {
        return likedPhotoList;
    }

    public void setLikedPhotoList(List<Photo> likedPhotoList) {
        this.likedPhotoList = likedPhotoList;
    }
*/

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", created=" + created +
                ", photoList=" + photoList +
    //            ", likedPhotoList=" + likedPhotoList +
                ", followers=" + followers +
                ", followed=" + followed +
                '}';
    }
}
