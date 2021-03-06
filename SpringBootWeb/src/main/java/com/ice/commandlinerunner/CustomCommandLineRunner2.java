package com.ice.commandlinerunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 20.CommandLineRunner 实现系统启动任务
 * 实现 CommandLineRunner
 * 组件
 * 启动顺序
 */
@Component
@Order(2)
public class CustomCommandLineRunner2 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("CustomCommandLineRunner2: " + args + ".");
    }
}
