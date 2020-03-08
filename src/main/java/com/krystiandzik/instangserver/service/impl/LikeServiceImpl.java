package com.krystiandzik.instangserver.service.impl;


import com.krystiandzik.instangserver.dao.LikeDao;
import com.krystiandzik.instangserver.models.Likes;
import com.krystiandzik.instangserver.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeDao likeDao;

    @Override
    public Likes save(Likes like) {
        return likeDao.save(like);
    }

    @Override
    public Likes findByUserId(Long userId) { return likeDao.findByUserId(userId); }

    @Override
    public void deleteByLikeId(Long userId) { likeDao.deleteByLikeId(userId); }

}
