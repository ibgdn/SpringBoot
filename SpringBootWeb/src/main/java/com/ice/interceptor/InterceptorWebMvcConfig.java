package com.ice.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 19.Spring Boot 中注册拦截器
 */
@Configuration
public class InterceptorWebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getCustomIntgerceptor()).addPathPatterns("/**");
    }

    @Bean
    CustomInterceptor getCustomIntgerceptor() {
        return new CustomInterceptor();
    }
}
