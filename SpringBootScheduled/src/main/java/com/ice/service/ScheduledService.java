package com.ice.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 8.Spring Boot 定时任务实现方案一(@Scheduled)
 */
@Service
public class ScheduledService {

    // 上一任务执行完成时间点，本次任务开始执行时间点，时间间隔3秒。
    @Scheduled(fixedDelay = 3000)
    public void fixedDelay() {
        System.out.println(new Date() + "   Fixed Delay 3000.");
    }

    // 上一任务开始执行时间点，与本次任务开始执行时间点间隔时间为4秒
    @Scheduled(fixedRate = 4000)
    public void fixedRate() {
        System.out.println(new Date() + "   Fixed Rate 4000.");
    }

    // 通过 cron 设置定时任务，每5秒执行一次
    @Scheduled(cron = "0/5 * * * * ?")
    public void cron() {
        System.out.println(new Date() + "   Cron 5000.");
    }

}
