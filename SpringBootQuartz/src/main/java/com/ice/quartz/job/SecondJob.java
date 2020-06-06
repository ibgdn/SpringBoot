package com.ice.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * 9.Spring Boot 定时任务实现方案二(Quartz)
 * 通过继承父类实现定时任务
 */
public class SecondJob extends QuartzJobBean {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println(new Date() + "    SecondJob executeInternal().    " + name);
    }
}
