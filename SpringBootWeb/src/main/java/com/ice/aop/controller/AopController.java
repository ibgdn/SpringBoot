package com.ice.aop.controller;

import com.ice.aop.service.AopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 25.Spring Boot 整合 AOP
 */
@RestController
public class AopController {
    @Autowired
    AopService service;

    @GetMapping("/aopGet")
    public String getById(Integer id) {
        return service.getById(id);
    }

    @GetMapping("/aopDelete")
    public void deleteById(Integer id) {
        service.deleteById(id);
    }
}
