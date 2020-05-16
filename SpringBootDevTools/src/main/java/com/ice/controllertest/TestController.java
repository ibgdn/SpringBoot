package com.ice.controllertest;

import com.ice.controllertest.bean.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/getHello")
    public String hello(String name) {
        return "Hello " + name + "!";
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {
        return book;
    }
}
