package com.krystiandzik.instangserver.dao;


import com.krystiandzik.instangserver.models.Likes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeDao extends CrudRepository<Likes, Long> {
    Likes save(Likes save);
    Likes findByUserId(Long userId);
    void deleteByLikeId(Long userId);
}
