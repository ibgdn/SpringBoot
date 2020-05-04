package com.ice.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 26.Spring Boot 自定义欢迎页
 */
@Controller
public class CustomIndexController {
    @GetMapping("/customIndex")
    public String customIndex() {
        return "customIndex";
    }
}
