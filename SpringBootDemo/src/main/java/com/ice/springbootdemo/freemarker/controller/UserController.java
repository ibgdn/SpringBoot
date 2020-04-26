package com.ice.springbootdemo.freemarker.controller;

import com.ice.springbootdemo.freemarker.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Random;

/**
 * freemarker 视图控制层
 */
@Controller
public class UserController {
    @GetMapping("/user")
    public String user(Model model) {
        ArrayList<User> users = new ArrayList<>();
        Random random = new Random();
        User user;
        for (int i = 0; i < 9; i++) {
            user = new User();
            user.setId((long) i);
            user.setUserName("userName " + i);
            user.setUserAddress("userAddress " + i);
            user.setGender(random.nextInt(3));
            users.add(user);
        }
        model.addAttribute("users", users);
        return "user";
    }
}
