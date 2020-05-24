package com.ice.dynamic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 12.动态配置权限
 */
@RestController
public class UserController {

    @GetMapping("/dynamic")
    public String dynamic() {
        return "Security Dynamic";
    }

    @GetMapping("/db/dynamic")
    public String db() {
        return "Security DB Dynamic";
    }

    @GetMapping("/admin/dynamic")
    public String admin() {
        return "Security Admin Dynamic";
    }

    @GetMapping("/user/dynamic")
    public String user() {
        return "Security User Dynamic";
    }
}
