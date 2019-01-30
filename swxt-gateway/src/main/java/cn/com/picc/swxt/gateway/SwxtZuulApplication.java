package cn.com.picc.swxt.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SwxtZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwxtZuulApplication.class, args);
	
	}

}

