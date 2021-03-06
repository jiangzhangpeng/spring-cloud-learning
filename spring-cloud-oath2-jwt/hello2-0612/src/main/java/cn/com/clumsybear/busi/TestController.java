package cn.com.clumsybear.busi;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

@RestController
public class TestController {
	@GetMapping("/product/{id}")
	public String getProduct(@PathVariable String id, HttpServletRequest req) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("用户名  : " + JSON.toJSONString(authentication.getPrincipal()));
		System.out.println("封装的传递信息  : " + AuthUtils.getReqUser(req));
		return "(Need Auth Request)product id : " + id;
	}

	@GetMapping("/order/{id}")
	public String getOrder(@PathVariable String id) {
		return "(No Auth Request)order id : " + id;
	}

}
