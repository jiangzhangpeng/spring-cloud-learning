package cn.com.clumsybear.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.com.clumsybear.bean.User;

@RestController
public class UserController {
	@RequestMapping(value="getUser1",method=RequestMethod.GET)
	public User getUser() {
		User user = new User();
		user.setId("1");
		user.setName("User 1");
		return user;
	}
	
	@RequestMapping(value="getUser2",method=RequestMethod.GET)
	public User getUser2() {
		User user = new User();
		user.setId("2");
		user.setName("User 2");
		return user;
	}
	
	@RequestMapping(value="getUser3",method=RequestMethod.GET)
	public User getUser3() {
		User user = new User();
		user.setId("3");
		user.setName("User 3");
		System.out.println("1111111111111111111111111");
		return user;
	}

}
