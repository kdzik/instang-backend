package com.krystiandzik.instangserver.service.impl;

import com.krystiandzik.instangserver.dao.UserDao;
import com.krystiandzik.instangserver.models.User;
import com.krystiandzik.instangserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    @Override
    public User findByUserId(Long userId) {
        return userDao.findByUserId(userId);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }
}
