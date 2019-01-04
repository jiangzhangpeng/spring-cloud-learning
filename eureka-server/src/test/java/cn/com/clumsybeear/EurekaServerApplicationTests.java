package cn.com.clumsybeear;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.com.clumsybear.EurekaServerApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=EurekaServerApplication.class)
@SpringBootConfiguration
public class EurekaServerApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("");
	}

}

