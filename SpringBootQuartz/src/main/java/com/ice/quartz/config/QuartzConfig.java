package com.ice.quartz.config;

import com.ice.quartz.job.SecondJob;
import org.quartz.JobDataMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;

import java.util.Date;

/**
 * 9.Spring Boot 定时任务实现方案二(Quartz)
 */
@Configuration
public class QuartzConfig {

    // 不支持传递参数
    @Bean
    MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean() {
        MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
        methodInvokingJobDetailFactoryBean.setTargetBeanName("firstJob");
        methodInvokingJobDetailFactoryBean.setTargetMethod("job");
        return methodInvokingJobDetailFactoryBean;
    }

    @Bean
    JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(SecondJob.class);
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("name", "Quartz");
        jobDetailFactoryBean.setJobDataMap(jobDataMap);
        return jobDetailFactoryBean;
    }

    // 触发器
    @Bean
    SimpleTriggerFactoryBean simpleTriggerFactoryBean() {
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
        simpleTriggerFactoryBean.setJobDetail(methodInvokingJobDetailFactoryBean().getObject());
        simpleTriggerFactoryBean.setStartTime(new Date());
        simpleTriggerFactoryBean.setRepeatInterval(3000);
        simpleTriggerFactoryBean.setRepeatCount(4);
        return simpleTriggerFactoryBean;
    }

    // 触发器
    @Bean
    CronTriggerFactoryBean cronTriggerFactoryBean() {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(jobDetailFactoryBean().getObject());
        cronTriggerFactoryBean.setCronExpression("*/2 * * * * ?");
        return cronTriggerFactoryBean;
    }

    // 启动定时任务，将两个 trigger 放入
    @Bean
    SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(simpleTriggerFactoryBean().getObject(), cronTriggerFactoryBean().getObject());
        return schedulerFactoryBean;
    }
}
