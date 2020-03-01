package com.krystiandzik.instangserver.controller;

import com.krystiandzik.instangserver.models.Photo;
import com.krystiandzik.instangserver.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @RequestMapping("/allPhotos")
    public List<Photo> getAllPhotos(){
        return photoService.findAll();
    }
}
