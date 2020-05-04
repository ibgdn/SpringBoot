package com.ice.servlet;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * 22.Spring Boot 整合 Web 基础组件 listener
 */
@WebListener
public class CustomListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("CustomListener requestDestroyed.");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("CustomListener requestInitialized.");
    }
}
