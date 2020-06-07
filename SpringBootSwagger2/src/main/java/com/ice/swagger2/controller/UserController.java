package com.ice.swagger2.controller;

import com.ice.swagger2.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 10.Spring Boot 整合 Swagger2
 */
@RestController
public class UserController {

    @GetMapping("/user")
    public User getUserById(Integer id){
        User user = new User();
        user.setId(id);
        return user;
    }
}
