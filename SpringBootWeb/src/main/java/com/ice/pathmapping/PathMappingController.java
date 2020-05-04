package com.ice.pathmapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 23.Spring Boot 路径映射
 */
@Controller
public class PathMappingController {
    // Controller 返回 View，没有其他操作。可以通过配置 addViewControllers，来统一添加。
    @GetMapping("/pathMapping")
    public String pathMapping() {
        return "pathMapping";
    }
}
