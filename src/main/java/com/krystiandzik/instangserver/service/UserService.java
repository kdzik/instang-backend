package com.krystiandzik.instangserver.service;

import com.krystiandzik.instangserver.models.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    User findByUserName(String userName);

    User findByUserId(Long userId);

    User save(User user);
}
