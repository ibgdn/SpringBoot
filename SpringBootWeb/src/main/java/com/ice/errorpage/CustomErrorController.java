package com.ice.errorpage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 15.Spring Boot 自定义异常数据
 */
@RestController
public class CustomErrorController {

    @GetMapping("/customError")
    public String customerErrorPage() {

        System.out.println(2 / 0);

        return "customErrorPage";
    }
}
