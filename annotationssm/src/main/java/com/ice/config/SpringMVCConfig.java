package com.ice.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.ice.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * Spring Mvc 的配置文件，相当于 spring-servlet.xml
 * <p>
 * 通过继承 WebMvcConfigurationSupport。
 */
@Configuration
@ComponentScan(basePackages = "com.ice", useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class), @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)})
public class SpringMVCConfig extends WebMvcConfigurationSupport {
    /*
        添加静态资源过滤
    */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /*
        添加拦截器
    */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // "/**" 代表任意多层路径
        registry.addInterceptor(myInterceptor()).addPathPatterns("/**");
    }

    @Bean
    MyInterceptor myInterceptor() {
        return new MyInterceptor();
    }
    // 添加拦截器 end

    /*
        json 序列化与反序列化
    */
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        converters.add(converter);
    }
}
