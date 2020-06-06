package com.ice.quartz.job;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 9.Spring Boot 定时任务实现方案二(Quartz)
 * 注册到 spring 容器中，使用中不支持传递参数。
 */
@Component
public class FirstJob {
    public void job() {
        System.out.println(new Date() + "    FirstJob job().");
    }
}
