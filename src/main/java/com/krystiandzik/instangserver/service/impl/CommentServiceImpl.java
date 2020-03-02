package com.krystiandzik.instangserver.service.impl;

import com.krystiandzik.instangserver.dao.CommentDao;
import com.krystiandzik.instangserver.models.Comment;
import com.krystiandzik.instangserver.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public Comment save(Comment comment) {
        return commentDao.save(comment);
    }
}
