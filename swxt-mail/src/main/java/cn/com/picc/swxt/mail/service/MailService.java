package cn.com.picc.swxt.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import cn.com.picc.swxt.mail.bean.Mail;
import cn.com.picc.swxt.mail.util.EmailConfigurations;

@Service
public class MailService {
	@Autowired
	private EmailConfigurations emailConfigs;
	@Autowired
	private JavaMailSenderImpl  mailSender;
	public String sendMail(Mail mail) {
		mailSender.set
		SimpleMailMessage message = new SimpleMailMessage();
		mailSender.send(message);
		return null;
	}

}
