package com.ice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Date;

@SpringBootTest
class SpringBootMailApplicationTests {

    @Autowired
    JavaMailSender javaMailSender;

    @Test
    void contextLoads() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("SpringBoot 测试邮件");
        simpleMailMessage.setText("通过 SpringBoot Mail 发送的测试邮件。");
        simpleMailMessage.setFrom("发送邮箱地址");
        simpleMailMessage.setSentDate(new Date());
        simpleMailMessage.setTo("接收邮箱地址");
        simpleMailMessage.setCc("抄送邮箱地址");
        simpleMailMessage.setBcc("密送邮箱地址");
        javaMailSender.send(simpleMailMessage);
    }

}
