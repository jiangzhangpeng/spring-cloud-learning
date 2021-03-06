package cn.com.clumsybear.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {
	@Autowired
	RestTemplate restTemplate;
	HystrixCircuitBreaker b;

	@HystrixCommand(fallbackMethod = "helloFallback")
	public String helloService() {
		return restTemplate.getForObject("http://HELLO-SERVICE/hello", String.class);
	}

	public String helloFallback() {
		return "error";
	}

}
