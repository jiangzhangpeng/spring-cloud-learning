package cn.com.clumsybear;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

@Configuration
public class FullLogConfiguration {
	@Bean
	Logger.Level feignLoggerLevel(){
		return Logger.Level.FULL;
	}
}
