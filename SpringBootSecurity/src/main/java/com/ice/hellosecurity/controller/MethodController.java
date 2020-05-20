package com.ice.hellosecurity.controller;

import com.ice.hellosecurity.service.MethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 9.方法安全
 */
@Controller
public class MethodController {
    @Autowired
    MethodService methodService;

    @GetMapping("adminMethod")
    public String adminMethod() {
        return methodService.adminMehtod();
    }

    @GetMapping("userMethod")
    public String userMethod() {
        return methodService.userMethod();
    }

    @GetMapping("anyRoleMethod")
    public String anyRoleMethod() {
        return methodService.anyRoleMethod();
    }
}
