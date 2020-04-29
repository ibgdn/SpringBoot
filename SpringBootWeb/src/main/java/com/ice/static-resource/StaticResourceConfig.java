package com.ice;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 5.两种方式自定义静态资源位置
 *
 * SpringBootWeb\src\main\resources\application.properties 文件的
 * spring.resources.static-locations=classpath:/ice-static/
 * 配置或此 java 类的配置保留一个即可。
 */
@Configuration
public class StaticResourceConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/ice-static/");
    }
}
