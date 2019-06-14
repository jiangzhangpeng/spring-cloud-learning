package cn.com.clumsybear;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import cn.com.clumsybear.filter.HostAddrKeyResolver;
import cn.com.clumsybear.filter.UriKeyResolver;

@SpringBootApplication
@EnableDiscoveryClient
public class SwxtGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwxtGatewayApplication.class, args);
	}

	@Bean
	@Primary
	public HostAddrKeyResolver hostAddrKeyResolver() {
		return new HostAddrKeyResolver();
	}
	
	
	@Bean
	public UriKeyResolver uriKeyResolver() {
		return new UriKeyResolver();
	}
}
