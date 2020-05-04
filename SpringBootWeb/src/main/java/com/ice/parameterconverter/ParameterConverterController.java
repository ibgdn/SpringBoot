package com.ice.parameterconverter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 24.Spring Boot 中使用类型转换器
 */
@RestController
public class ParameterConverterController {
    @GetMapping("parameterConverter")
    public void parameterConverter(Date birth) {
        System.out.println(birth);
    }
}
