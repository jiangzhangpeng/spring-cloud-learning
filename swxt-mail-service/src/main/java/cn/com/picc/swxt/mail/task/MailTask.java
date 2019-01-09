package cn.com.picc.swxt.mail.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.com.picc.swxt.mail.service.DzfpylService;
import cn.com.picc.swxt.mail.service.MailService;
import cn.com.picc.swxt.mail.service.SkriskService;

@Component
@EnableScheduling
@SuppressWarnings("deprecation")
public class MailTask {
	private static final Logger logger = LoggerFactory.getLogger(MailTask.class);
	@Autowired
	private DzfpylService dzfpylService;

	@Autowired
	private SkriskService skriskService;

	@Async
	@Scheduled(cron = "0 0/60 * * * ?")
	public void sendSKRiskMail() {
		logger.debug("come into MailTask.sendSKRiskMail");
		try {
			skriskService.sendSimpleMail();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("MailTask.sendSKRiskMail error:", e.getMessage());
		}
		logger.debug("leave MailTask.sendSKRiskMail");

	}

	@Async
	@Scheduled(cron = "0 0/60 * * * ?")
	public void sendDzfpylMail() {
		logger.debug("come into MailTask.sendDzfpylMail");
		try {
			dzfpylService.sendSimpleMail();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("MailTask.sendDzfpylMail error:", e.getMessage());
		}
		logger.debug("leave MailTask.sendDzfpylMail");
	}

}
