package com.krystiandzik.instangserver.controller;

import com.krystiandzik.instangserver.models.Photo;
import com.krystiandzik.instangserver.models.User;
import com.krystiandzik.instangserver.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/rest")
@CrossOrigin
public class PhotoResource {

    private String imageName;

    @Value("${images.resource}")
    private String imagesDir;


    @Autowired
    private PhotoService photoService;

    @PostMapping("/photo/upload")
    public String upload(@RequestParam("myFile") MultipartFile file){
        String fileName = file.getOriginalFilename();

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        String randomName = generatedString+fileName;

        String path = new File(imagesDir)+"/"+randomName;
        imageName = randomName;
        try {
            file.transferTo(new File(path));
            System.out.println(path);
        } catch (IOException e){
            e.printStackTrace();
        }
        return "Upload successful";
    }

    @PostMapping("/photo/add")
    public Photo addPhoto(@RequestBody Photo photo){
        photo.setImageName(imageName);
        return photoService.save(photo);
    }

    @PostMapping("/photo/user")
    public List<Photo> getPhotosByUser(@RequestBody User user){
        return photoService.findByUser(user);
    }

    @PostMapping("/photo/photoId")
    public Photo getPhotoByPhotoId (@RequestBody Long photoId) {
        return photoService.findByPhotoId(photoId);
    }

    @PostMapping("/photo/update")
    public void updatePhoto(@RequestBody Photo photo){
        Photo currentPhoto = photoService.findByPhotoId(photo.getPhotoId());
        currentPhoto.setLikes(photo.getLikes());
        photoService.save(currentPhoto);
    }

}
