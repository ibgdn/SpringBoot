package com.ice.hellosecurity.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.security.auth.login.CredentialException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

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
                .antMatchers("user/**").hasAnyRole("user", "admin")
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
                // 登录页面
                .loginPage("/login")
                .usernameParameter("un")
                .passwordParameter("pw")
                // 登录成功
                .successHandler((request, response, authentication) -> {
                    response.setContentType("application/text;charset=utf-8");
                    PrintWriter writer = response.getWriter();
                    Map<Object, Object> map = new HashMap<>();
                    map.put("status", 002);
                    map.put("msg", authentication.getPrincipal());
                    writer.write(new ObjectMapper().writeValueAsString(map));
                    writer.flush();
                    writer.close();
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

                    }
                })
                // 登录失败
                .failureHandler(((request, response, exception) -> {
                    response.setContentType("application/text;charset=utf-8");
                    PrintWriter writer = response.getWriter();
                    Map<Object, Object> map = new HashMap<>();
                    map.put("status", 104);
                    if (exception instanceof LockedException) {
                        map.put("msg", "账户被锁定，登录失败");
                    } else if (exception instanceof BadCredentialsException) {
                        map.put("msg", "错误的凭证，用户名或密码输入错误");
                    } else if (exception instanceof DisabledException) {
                        map.put("msg", "账户被禁用，登录失败");
                    } else if (exception instanceof AccountExpiredException) {
                        map.put("msg", "账户过期，登录失败");
                    } else if (exception instanceof CredentialsExpiredException) {
                        map.put("msg", "密码过期");
                    } else {
                        map.put("msg", "登录失败");
                    }
                    map.put("msg", exception.getMessage());
                    writer.write(new ObjectMapper().writeValueAsString(map));
                    writer.flush();
                    writer.close();
                }))
                // 登录相关的接口直接访问
                .permitAll()
                .and()
                // 通过 postman 访问，关闭 csrf 攻击保护
                .csrf().disable();
    }
}
