package com.ice.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 项目的初始化文件，相当于 web.xml
 */
public class WebInit implements WebApplicationInitializer {
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext acwac = new AnnotationConfigWebApplicationContext();
        acwac.setServletContext(servletContext);
        acwac.register(SpringConfig.class);
        ServletRegistration.Dynamic springMvc = servletContext.addServlet("springMvc", new DispatcherServlet(acwac));
        springMvc.addMapping("/");
        springMvc.setLoadOnStartup(1);

    }
}
