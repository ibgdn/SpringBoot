package com.ice.xml;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 18.Spring Boot 中加载 XML 配置
 */
@Configuration
@ImportResource(locations = "classpath:xmlbeans.xml")
public class XmlBeanWebMvcConfig {
}
