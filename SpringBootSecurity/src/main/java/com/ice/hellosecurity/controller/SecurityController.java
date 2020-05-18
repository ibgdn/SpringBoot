package com.ice.hellosecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2.Spring  Security 初体验
 */
@RestController
public class SecurityController {
    @GetMapping("/helloSecurity")
    public String security() {
        return "Hello Security.";
    }
}
