package com.krystiandzik.instangserver.service;

import com.krystiandzik.instangserver.models.Photo;
import com.krystiandzik.instangserver.models.User;

import java.util.List;

public interface PhotoService {
    Photo save(Photo photo);

    List<Photo> findAll();

    List<Photo> findByUser(User user);

    Photo findByPhotoId(Long photoId);
}
