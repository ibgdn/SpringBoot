package com.ice.controller;

import com.ice.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    /**
     * @RequestMapping( method = {RequestMethod.GET})
     * 请求方法为 get 的 RequestMapping
     */
    @GetMapping(value = "/hello", produces = "text/html;charset=utf-8")
    public String hello() {
        return helloService.sayHello();
    }

}
