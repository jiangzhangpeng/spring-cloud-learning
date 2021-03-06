package cn.com.clumsybear.demo.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.com.clumsybear.demo.bean.User;

@RestController
public class UserController {

	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "getUser", method = RequestMethod.GET)
	public User getUser() {
		ServiceInstance instance = client.getLocalServiceInstance();
		System.out.println("/hello,host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
		User user = new User();
		user.setId("1");
		user.setName("user_1");
		user.setGender("F");
		user.setAge(6);
		return user;
	}
	
	@RequestMapping(value = "/test-user1", method = RequestMethod.GET)
	public String hello1() throws Exception {
		ServiceInstance instance = client.getLocalServiceInstance();
		//int randomTime = new Random().nextInt(3000);
		//Thread.sleep(randomTime);
		System.out.println("/test-hello1,host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
		return "test user!!!!!";
	}
}
