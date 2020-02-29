package com.krystiandzik.instangserver.dao;

import com.krystiandzik.instangserver.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    List<User> findAll();

    User findByUserName(String userName);
    User findByUserId(Long userId);
    User save(User user);
}
