package com.ice.requestparameter;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 12.@ControllerAdvice 请求参数预处理
 */
@RestController
public class RequestParameterController {
    @PostMapping("/requestParameter")
    public String requestParameter(@ModelAttribute("book") Book book, @ModelAttribute("author") Author author) {
        System.out.println("book: " + book);
        System.out.println("author: " + author);
        return "requestParameter";
    }
}
