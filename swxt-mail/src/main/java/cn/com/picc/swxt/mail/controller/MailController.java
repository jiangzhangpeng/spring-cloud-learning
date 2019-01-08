package cn.com.picc.swxt.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.com.picc.swxt.mail.bean.Mail;
import cn.com.picc.swxt.mail.service.MailService;

@RestController
public class MailController {
	@Autowired
	private MailService mailService;

	@RequestMapping(value = "/sendmail", method = RequestMethod.POST)
	public String sendMail(@RequestBody Mail mail) {
		System.out.println(mail.getFrom());
		System.out.println(mail.getTo());
		System.out.println(mail.getSubject());
		System.out.println(mail.getContent());
		mailService.sendMail(mail);
		return null;
	}

}
