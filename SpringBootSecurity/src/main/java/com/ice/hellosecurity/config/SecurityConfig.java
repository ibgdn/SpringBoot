package com.ice.hellosecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 3.手工配置用户名密码
 * 通过这个类的配置或是 *.properties 文件的配置实现自定义用户登录
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder() {
        // 密码无需加密
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("sec1").password("123456").roles("admin")
                .and()
                .withUser("sec2").password("789012").roles("user");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 访问路径 /admin/** 属于 admin 角色
                .antMatchers("/admin/**").hasRole("admin")
                // 访问路径 user/** 属于 user、admin 角色
                .antMatchers("user/**").hasAnyRole("user","admin")
                // 与上一行语句等效
//                .antMatchers("user/**").access("hasAnyRole('user','admin')")
//                .antMatchers("user/**").access("hasRole('user').and().hasRole('admin')")
                // 其他请求登录之后就可以访问
                .anyRequest().authenticated()
                .and()
                // 表单登录
                .formLogin()
                // 处理登录的 URL
                .loginProcessingUrl("/doLogin")
                // 登录相关的接口直接访问
                .permitAll()
                .and()
                // 通过 postman 访问，关闭 csrf 攻击保护
                .csrf().disable();
    }
}
