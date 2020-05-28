package com.ice.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 16.整合 Shiro 方式二
 */
@RestController
public class ShiroController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello Shiro2";
    }

    @GetMapping("/login")
    public String login() {
        return "Please Login";
    }

    @PostMapping("/doLogin")
    public void doLogin(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username, password));
            System.out.println("Success.");
        } catch (Exception e) {
            System.out.println("Fail.");
            e.printStackTrace();
        }

    }
}
