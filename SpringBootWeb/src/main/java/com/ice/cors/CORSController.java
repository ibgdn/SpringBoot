package com.ice.cors;

import org.springframework.web.bind.annotation.*;

/**
 * 17.Spring Boot 通过 CORS 实现跨域
 */
@RestController
// 整个控制层的请求允许跨域
//@CrossOrigin(origins = "http://localhost:49033")
public class CORSController {
    @GetMapping("/cors")
    // 单个请求允许跨域
//    @CrossOrigin(origins = "http://localhost:49033")
    public String cors() {
        return "cors";
    }

    @PutMapping("/doPut")
    public String doPut() {
        return "cors doPut";
    }
}
