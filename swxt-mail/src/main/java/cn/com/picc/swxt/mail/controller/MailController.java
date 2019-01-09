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

@RestController
public class MailController {
	private static final Logger logger = LoggerFactory.getLogger(MailController.class);
	@Autowired
	private MailService mailService;
	@Autowired
	private DzfpylService dzfpylService;

	@RequestMapping(value = "/sendSimpleMail", method = RequestMethod.POST)
	public String sendSimpleMail(@RequestBody Mail mail) {
		logger.debug("come into MailController");
		logger.debug("call send mail service");
		String result = mailService.sendSimpleMail(mail);
		logger.debug("return to the caller");
		return result;
	}
	
	
	@RequestMapping(value = "/sendDzfpylManually", method = RequestMethod.GET)
	public String sendDzfpylManually() {
		logger.debug("come into sendDzfpylManually controller");
		logger.debug("call send mail service ");
		dzfpylService.sendSimpleMail();
		logger.debug("return to the caller");
		return "success";
	}

}
