package cn.com.clumsybear.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("hello-service")
public interface UserService {
	@RequestMapping("getUser")
	String getUser();
}
