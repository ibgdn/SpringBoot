package com.ice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 17.Spring Security 使用 JSON 登录
 */
@RestController
public class SecurityJSONController {
    @GetMapping("/securityJSON")
    public String securityJSON() {
        return "Security JSON.";
    }
}
