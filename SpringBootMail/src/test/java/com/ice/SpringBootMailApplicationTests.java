package com.ice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

@SpringBootTest
class SpringBootMailApplicationTests {

    @Autowired
    JavaMailSender javaMailSender;

    // 发送简单消息邮件
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

    // 发送带附件的邮件
    @Test
    void sendAttachment() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setSubject("SpringBoot 附件测试邮件");
        mimeMessageHelper.setText("通过 SpringBoot Mail 发送的附件测试邮件。");
        mimeMessageHelper.setFrom("发送邮箱地址");
        mimeMessageHelper.setSentDate(new Date());
        mimeMessageHelper.setTo("接收邮箱地址");
        mimeMessageHelper.setCc("抄送邮箱地址");
        mimeMessageHelper.setBcc("密送邮箱地址");
        mimeMessageHelper.addAttachment("附件图片", new File("E:\\cache\\desktop\\171744c434465b69.png"));
        javaMailSender.send(mimeMessage);
    }

}
