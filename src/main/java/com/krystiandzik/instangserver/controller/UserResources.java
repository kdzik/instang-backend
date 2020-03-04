package com.krystiandzik.instangserver.controller;

import com.krystiandzik.instangserver.models.User;
import com.krystiandzik.instangserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class UserResources {

    @Autowired
    private UserService userService;

    @GetMapping("/user/users")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping("/user/{username}")
    public User findByUserName(@PathVariable String username){
        return userService.findByUserName(username);
    }

    @PostMapping("/user/id/{id}")
    public User findByUserId(@PathVariable Long id){
        return userService.findByUserId(id);
    }


    @PutMapping("/user/update")
    public User updateUser(@RequestBody User user){
        return userService.save(user);
    }

   /* @PutMapping("/user/update/followers")
    public User updateFollow(@RequestBody User user){
     //   User user2 = findByUserId(user.getUserId());
     //   System.out.println("Przekazany: " + user.toString());
     //   System.out.println("Z bazy: " + user2.toString());
     //   user2.setFollowed(user.getFollowed());
      //  user2.setFollowers((user.getFollowers()));
       // System.out.println(user2.toString());
     //   return userService.save(user2);
    }*/
}
