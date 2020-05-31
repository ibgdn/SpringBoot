package com.ice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 18.Spring Security 整合 Jwt
 */
@RestController
public class JWTController {
    @GetMapping("/jwt")
    public String jwt() {
        return "Hello JWT";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Hello Admin";
    }
}
