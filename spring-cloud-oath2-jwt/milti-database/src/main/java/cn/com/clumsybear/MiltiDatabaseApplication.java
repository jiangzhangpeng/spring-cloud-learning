package cn.com.clumsybear;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class MiltiDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiltiDatabaseApplication.class, args);
	}

}
