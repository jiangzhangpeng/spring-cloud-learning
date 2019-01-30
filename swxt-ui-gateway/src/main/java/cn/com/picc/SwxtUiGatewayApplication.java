package cn.com.picc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SwxtUiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwxtUiGatewayApplication.class, args);
	}

}

