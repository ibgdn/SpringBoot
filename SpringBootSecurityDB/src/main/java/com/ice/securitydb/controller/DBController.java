package com.ice.securitydb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 10.基于数据库的认证
 */
@RestController
public class DBController {
    @GetMapping("/dbSecurity")
    public String dbSecurity() {
        return "DB Security.";
    }

    @GetMapping("/adminSecurity")
    public String admin() {
        return "DB admin.";
    }

    @GetMapping("/dbaSecurity")
    public String dba() {
        return "DB DBA.";
    }

    @GetMapping("/userSecurity")
    public String user() {
        return "DB user.";
    }
}
