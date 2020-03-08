package com.krystiandzik.instangserver.controller;

import com.krystiandzik.instangserver.models.Follow;
import com.krystiandzik.instangserver.models.Photo;
import com.krystiandzik.instangserver.models.User;
import com.krystiandzik.instangserver.service.PhotoService;
import com.krystiandzik.instangserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @Autowired
    private UserService userService;

    @RequestMapping("/allPhotos")
    public List<Photo> getAllPhotos(){
        return photoService.findAll();
    }

    @PostMapping("/followedPhotos")
    public List<Photo> getFollowedPhotos(@RequestBody User user){
        List<Follow> followed = user.getFollowed();
        List<Photo> photos = new ArrayList<>();
        for (Follow follow : followed){
            List<Photo> followedUserPhotos = userService.findByUserId(follow.getUserId()).getPhotoList();
            for(Photo photo: followedUserPhotos){
                photos.add(photo);
            }
        }
        return photos;
    }
}
