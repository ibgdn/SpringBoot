package com.ice.controller;

import com.ice.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
    @Autowired
    public HelloService helloService;

    @GetMapping(value = "/hello", produces = "text/html;charset=utf-8")
    public String hello() {
        return helloService.sayHello();
    }

    @GetMapping(value = "/jsonData")
    public List<String> data() {
        int length = 5;
        ArrayList<String> list = new ArrayList<String>(length);
        for (int i = 0; i < length; i++) {
            list.add("for i >>> " + i);
        }
        return list;
    }
}
