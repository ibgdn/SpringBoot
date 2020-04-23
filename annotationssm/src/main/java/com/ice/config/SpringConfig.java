package com.ice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Spring 的配置文件，相当于 applicationContext.xml
 */
@Configuration
@ComponentScan(basePackages = "com.ice", useDefaultFilters = true, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class)} )
public class SpringConfig {
}
