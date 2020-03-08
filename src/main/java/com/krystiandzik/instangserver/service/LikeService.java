package com.krystiandzik.instangserver.service;

import com.krystiandzik.instangserver.models.Likes;

public interface LikeService {
    Likes save(Likes like);
    Likes findByUserId(Long userId);
    void deleteByLikeId(Long userId);
}
