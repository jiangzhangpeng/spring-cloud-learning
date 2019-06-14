package cn.com.clumsybear.demo.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.clumsybear.demo.bean.User;

@RestController
public class HelloController {

	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/hello111", method = RequestMethod.GET)
	public String index() throws Exception {
		ServiceInstance instance = client.getLocalServiceInstance();
		int randomTime = new Random().nextInt(3000);
		//Thread.sleep(randomTime);
		System.out.println("/hello,host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
		return "Hello World";
	}

	@RequestMapping(value = "/hello1", method = RequestMethod.GET)
	public String hello(@RequestParam String name) {
		return "hello " + name;
	}

	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
	public User hello(@RequestHeader String name, @RequestHeader Integer age) {
		return new User(name, age);
	}

	@RequestMapping(value = "/hello3", method = RequestMethod.POST)
	public String hello(@RequestBody User user) {
		return "Hello " + user.getName() + ", " + user.getAge();
	}
	
	@RequestMapping(value = "/test-hello1", method = RequestMethod.GET)
	public String hello1() throws Exception {
		ServiceInstance instance = client.getLocalServiceInstance();
		int randomTime = new Random().nextInt(3000);
		//Thread.sleep(randomTime);
		System.out.println("/test-hello1,host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
		return "Hello World!!!!!";
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() throws Exception {
		ServiceInstance instance = client.getLocalServiceInstance();
		int randomTime = new Random().nextInt(3000);
		//Thread.sleep(randomTime);
		System.out.println("/test-hello1,host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
		return "Hello World!!!!!";
	}

}
