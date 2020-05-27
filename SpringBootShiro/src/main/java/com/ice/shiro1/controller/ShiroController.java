package com.ice.shiro1.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 15.整合 Shiro 方式一
 */
@Controller
public class ShiroController {

    @GetMapping("/login")
    public String shiroLogin() {
        return "Shiro login";
    }

    @PostMapping("/doLogin")
    public void doLogin(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username, password));
            System.out.println("Login Success.");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("Login Fail. e: " + e);
        }
    }

    @GetMapping("/hello")
    public String test() {
        return "test";
    }
}
