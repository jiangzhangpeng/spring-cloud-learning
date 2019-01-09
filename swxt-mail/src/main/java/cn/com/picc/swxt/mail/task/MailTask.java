package cn.com.picc.swxt.mail.task;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.com.picc.swxt.mail.service.MailService;

@Component
@SuppressWarnings("deprecation")
public class MailTask {

	@Autowired
	private MailService mailService;
	

	@Scheduled(cron = "0 0/2 * * * ?")
	public void sendSKRiskMail() {
		
	}

	@Scheduled(cron = "0 0/60 * * * ?")
	public void sendDZFPYLMail() {
		
	}

}
