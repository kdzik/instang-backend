package com.krystiandzik.instangserver.controller;


import com.krystiandzik.instangserver.models.Likes;
import com.krystiandzik.instangserver.models.Photo;
import com.krystiandzik.instangserver.service.LikeService;
import com.krystiandzik.instangserver.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class LikeResources {

    @Autowired
    private PhotoService photoService;

    @Autowired
    private LikeService likeService;

    @PostMapping("/like/add")
    public void addLike(@RequestBody Likes like){
        Photo photo = photoService.findByPhotoId(like.getPhotoId());
        List<Likes> likeList = photo.getLikes();
        like.setPhoto(photo);
        likeService.save(like);
    }

    @PostMapping("/like/remove")
    @Transactional
    public void removeLike(@RequestBody Long userId){
        Likes like = likeService.findByUserId(userId);
        System.out.println(like.toString());
        likeService.deleteByLikeId(like.getLikeId());
    }
}
