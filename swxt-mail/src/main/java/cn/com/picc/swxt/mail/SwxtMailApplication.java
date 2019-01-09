package cn.com.picc.swxt.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringCloudApplication
public class SwxtMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwxtMailApplication.class, args);
	}
	
	@Bean
	public JavaMailSenderImpl getJavaMailSenderImpl() {
		return new JavaMailSenderImpl();
	}
	

}

