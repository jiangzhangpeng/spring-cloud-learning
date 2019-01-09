package cn.com.picc.swxt.mail.service;

import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import cn.com.picc.swxt.mail.bean.Mail;
import cn.com.picc.swxt.mail.util.EmailConfigurations;

@Service
public class MailService {
	private static final Logger logger = LoggerFactory.getLogger(MailService.class);
	@Autowired
	private EmailConfigurations emailConfigs;
	@Autowired
	private JavaMailSenderImpl mailSender;

	public String sendSimpleMail(Mail mail) {
		logger.debug("come into sendSimpleMail");
		Map<String, String> config = emailConfigs.getMailConfigs().get(mail.getFrom());
		if (config == null) {
			logger.info("can not find config,return fail");
			return "fail";
		}
		logger.debug("config:");
		logger.debug("    from:" + config.get("user"));
		logger.debug("    host:" + config.get("host"));
		logger.debug("    to:" + mail.getTo());
		logger.debug("    subject:" + mail.getSubject());
		logger.debug("    content:" + mail.getContent());
		try {
			mailSender.setHost(config.get("host"));
			mailSender.setDefaultEncoding("utf-8");
			mailSender.setProtocol(config.get("protocol"));
			mailSender.setUsername(config.get("user"));
			mailSender.setPassword(config.get("password"));
			
			//Properties prop = new Properties();
			//prop.setProperty("mail.smtp.auth", "true");
			//mailSender.setJavaMailProperties(prop);
		
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(config.get("user")+"@picc.com.cn");
			message.setTo(mail.getTo().split(";"));
			message.setSubject(mail.getSubject());
			message.setText(mail.getContent());
			mailSender.send(message);
			logger.debug("send successfully,return success");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("send error:" + e.getLocalizedMessage());
			return "fail";
		}
		return "success";
	}

}
