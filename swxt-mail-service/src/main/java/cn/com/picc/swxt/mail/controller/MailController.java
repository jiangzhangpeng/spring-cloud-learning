package cn.com.picc.swxt.mail.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.com.picc.swxt.mail.bean.Mail;
import cn.com.picc.swxt.mail.service.DzfpylService;
import cn.com.picc.swxt.mail.service.MailService;
import cn.com.picc.swxt.mail.service.SkriskService;

@RestController
public class MailController {
	private static final Logger logger = LoggerFactory.getLogger(MailController.class);
	@Autowired
	private MailService mailService;
	@Autowired
	private DzfpylService dzfpylService;
	@Autowired
	private SkriskService skriskService;

	@RequestMapping(value = "/sendSimpleMail", method = RequestMethod.POST)
	public String sendSimpleMail(@RequestBody Mail mail) {
		logger.debug("come into MailController.sendSimpleMail");
		logger.debug("call send mail service");
		try {
			return mailService.sendSimpleMail(mail);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("sendSimpleMail error:", e.getMessage());
			return "fail";
		} finally {
			logger.debug("return to the caller");
		}
	}

	@RequestMapping(value = "/sendDzfpylManually", method = RequestMethod.GET)
	public String sendDzfpylManually() {
		logger.debug("come into sendDzfpylManually controller");
		try {
			logger.debug("call send mail service ");
			dzfpylService.sendSimpleMail();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("sendDzfpylManually error:", e.getMessage());
			return "fail";
		}
		logger.debug("return to the caller");
		return "success";
	}

	@RequestMapping(value = "/sendSkRiskManually", method = RequestMethod.GET)
	public String sendSkriskManually() {
		logger.debug("come into sendSkriskManually controller");
		logger.debug("call send mail service ");
		try {
			skriskService.sendSimpleMail();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("sendSkriskManually error:", e.getMessage());
			return "fail";
		}
		logger.debug("return to the caller");
		return "success";
	}

}
