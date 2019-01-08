package cn.com.clumsybear.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestEncryptController {
	@Value("${pass.value}")
	private String password;

	@RequestMapping(value = "password", method = RequestMethod.GET)
	public String getPassword() {
		return this.password;
	}

}
