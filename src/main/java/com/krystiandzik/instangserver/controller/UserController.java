package com.krystiandzik.instangserver.controller;

import com.krystiandzik.instangserver.models.User;
import com.krystiandzik.instangserver.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> json)  throws ServletException {
        if(json.get("username") == null || json.get("password") == null) {
            throw new ServletException("Please fill in username and password");
        }

        String userName = json.get("username");
        String password = json.get("password");

        User user = userService.findByUserName(userName);

        if(user == null) {
            throw new ServletException("User name not found");
           }

        String pwd = user.getPassword();

        if(!password.equals(pwd)) {
            throw new ServletException("Invalid login. Please check your username and password");
        }
        final String token = Jwts.builder().setSubject(userName).claim("roles", "user").setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact();
        System.out.println(token);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return userService.save(user);
    }
}
