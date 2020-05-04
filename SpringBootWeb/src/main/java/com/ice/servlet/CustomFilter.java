package com.ice.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 22.Spring Boot 整合 Web 基础组件 filter
 */
@WebFilter(urlPatterns = "/**")
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CustomFilter init.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("CustomFilter doFilter.");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("CustomFilter destroy.");
    }
}
