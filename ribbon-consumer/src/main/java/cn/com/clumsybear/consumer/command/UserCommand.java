package cn.com.clumsybear.consumer.command;

import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommand;

import cn.com.clumsybear.consumer.bean.User;

public class UserCommand extends HystrixCommand<User> {
	private RestTemplate restTemplate;
	private Long id;

	public UserCommand(Setter setter, RestTemplate restTemplate, Long id) {
		super(setter);
		this.restTemplate = restTemplate;
		this.id = id;
	}

	@Override
	protected User run() throws Exception {
		return restTemplate.getForObject("http://HELLO-SERVICE/getUser", User.class, id);
	}

	@Override
	protected User getFallback() {
		return new User();
	}

	@Override
	protected String getCacheKey() {
		return String.valueOf(id);
	}
}
