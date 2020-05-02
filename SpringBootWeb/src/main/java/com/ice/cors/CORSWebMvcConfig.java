package com.ice.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 17.Spring Boot 通过 CORS 实现跨域
 */
@Configuration
public class CORSWebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:49033")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(30 * 1000);
    }
}
