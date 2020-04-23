package com.ice.controller;

import com.ice.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    public HelloService helloService;

    @GetMapping(value = "/hello", produces = "text/html;charset=utf-8")
    public String hello() {
        return helloService.sayHello();
    }
}
