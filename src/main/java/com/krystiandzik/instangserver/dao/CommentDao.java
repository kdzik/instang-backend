package com.krystiandzik.instangserver.dao;

import com.krystiandzik.instangserver.models.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDao extends CrudRepository<Comment, Long> {
    Comment save(Comment save);
}
