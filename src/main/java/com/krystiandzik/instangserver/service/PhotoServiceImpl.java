package com.krystiandzik.instangserver.service;

import com.krystiandzik.instangserver.dao.PhotoDao;
import com.krystiandzik.instangserver.models.Photo;
import com.krystiandzik.instangserver.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoDao photoDao;

    @Override
    public Photo save(Photo photo) {
        return photoDao.save(photo);
    }

    @Override
    public List<Photo> findAll() {
        return photoDao.findAll();
    }

    @Override
    public List<Photo> findByUser(User user) {
        return photoDao.findByUser(user);
    }

    @Override
    public Photo findByPhotoId(Long photoId) {
        return photoDao.findByPhotoId(photoId);
    }
}
