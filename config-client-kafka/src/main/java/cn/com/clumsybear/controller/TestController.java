package cn.com.clumsybear.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {
	@Value("${from}")
	private String from;
	
	@Value("${jdbc.password}")
	private String password;

	@RequestMapping(value = "/password1", method = RequestMethod.GET)
	public String getPassword() {
		return this.password;
	}
	
	@RequestMapping("/from")
	public String from() {
		return this.from;
	}
}
