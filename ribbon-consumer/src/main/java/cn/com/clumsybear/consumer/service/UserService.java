package cn.com.clumsybear.consumer.service;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;

import cn.com.clumsybear.consumer.bean.User;

public class UserService {
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "defaultUser")
	@CacheResult(cacheKeyMethod="getUserByIdCacheKey")
	public User getUserById(Long id) {
		return restTemplate.getForObject("", User.class);
	}

	public User defaultUser() {
		return new User();
	}
	
	private long getUserByIdCacheKey(Long id) {
		return id;
	}

	@HystrixCommand
	public Future<User> getUserByIdAsync(final Long id) {
		return new AsyncResult<User>() {
			@Override
			public User invoke() {
				return restTemplate.getForObject("http://HELLO-SERVICE/getUser", User.class);
			}

		};
	}

}
