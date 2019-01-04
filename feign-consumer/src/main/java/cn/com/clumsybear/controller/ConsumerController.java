package cn.com.clumsybear.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.com.clumsybear.bean.User;
import cn.com.clumsybear.service.HelloService;

@RestController
public class ConsumerController {
	@Autowired
	HelloService helloService;

	@RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
	public String helloConsumer() {
		return helloService.hello();
	}
	
	@RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
	public String helloConsumer2() {
		StringBuilder sb = new StringBuilder();
		sb.append(helloService.hello()).append("\n");
		sb.append(helloService.hello("chong")).append("\n");
		sb.append(helloService.hello("chong",7)).append("\n");
		sb.append(helloService.hello(new User("chong",7))).append("\n");
		return sb.toString();
	}
}
