package com.ice.json.config;

/*
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
*/
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

/**
 * 2.使用 Gson 处理 JSON
 */
@Configuration
public class GSONWebConfig {

/*
    @Bean
    GsonHttpMessageConverter gsonHttpMessageConverter() {
        // 会覆盖 Gson
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(new GsonBuilder().setDateFormat("yy-MM-dd").create());
        return converter;
    }
*/

/*
    @Bean
    Gson gson() {
        // 会被 GsonHttpMessageConverter 覆盖
        return new GsonBuilder().setDateFormat("yyyy--MM--dd").create();
    }
*/
}
