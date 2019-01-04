package cn.com.clumsybear.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.com.clumsybear.consumer.bean.User;
import cn.com.clumsybear.consumer.service.HelloService;



@RestController
public class ConsumerController {
	
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	HelloService helloService;

	@HystrixCommand
	@RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
	public String helloConsumer() {
		return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
	}
	
	
	@RequestMapping(value = "/getuser-consumer", method = RequestMethod.GET)
	public String getUserConsumer() {
		User user = restTemplate.getForEntity("http://HELLO-SERVICE/getUser", User.class).getBody();
		return user.getId()+"-"+user.getName()+"-"+user.getGender()+"-"+user.getAge();
	}
	
	@RequestMapping(value = "/getuser-consumer1", method = RequestMethod.GET)
	public String getUserConsumer1() {
		
		User user = restTemplate.getForObject("http://HELLO-SERVICE/getUser", User.class);
		return user.getId()+"-"+user.getName()+"-"+user.getGender()+"-"+user.getAge();
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		
		return helloService.helloService();
	}

}
