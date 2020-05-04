package com.ice.pathmapping;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 23.Spring Boot 路径映射
 */
@Configuration
public class PathMappingWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/pathMapping1").setViewName("pathMapping");
    }
}
