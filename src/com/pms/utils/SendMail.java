package com.pms.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SendMail {
	
	@Autowired
    private JavaMailSender javaMailSender;

    /**
     * @Description: 执行发送邮件
     * @param toEmail     收件人邮箱
     * @param code        邮件内容
     */
    public void sendCode(String toEmail, String code) throws Exception {
    	SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("740324579@qq.com");
		message.setTo(toEmail);
		message.setSubject("物业管理系统邮件服务");
		message.setText("消息内容是:" + code);
		javaMailSender.send(message);
    }
}

