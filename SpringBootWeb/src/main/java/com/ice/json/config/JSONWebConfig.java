package com.ice.json.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.input.DataFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.text.SimpleDateFormat;

/**
 * 1.Spring Boot默认的 JSON 解析方案配置文件
 */
@Configuration
public class JSONWebConfig {
    @Bean
    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        // 编码格式推荐使用（会覆盖ObjectMapper）
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM/dd"));
        converter.setObjectMapper(mapper);
        return converter;
    }

    @Bean
    ObjectMapper objectMapper () {
        // 日期格式推荐使用（会被 MappingJackson2HttpMessageConverter 覆盖）
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy`MM`dd"));
        return mapper;
    }
}
