package com.ice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Spring Mvc 的配置文件，相当于 spring-servlet.xml
 */
@Configuration
@ComponentScan(basePackages = "com.ice", useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class), @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)})
public class SpringMVCConfig {
}
