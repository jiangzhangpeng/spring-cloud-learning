package cn.com.clumsybear;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HelloConsulApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloConsulApplication.class, args);
	}

}

