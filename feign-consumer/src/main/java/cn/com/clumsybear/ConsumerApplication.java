package cn.com.clumsybear;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import feign.Logger;

@EnableFeignClients
//@EnableDiscoveryClient
//@SpringBootApplication
@SpringCloudApplication
public class ConsumerApplication {
	@Bean
	Logger.Level feignLoggerLevel(){
		return Logger.Level.FULL;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
}
