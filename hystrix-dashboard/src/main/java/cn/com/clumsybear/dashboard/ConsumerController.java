package cn.com.clumsybear.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class ConsumerController {
	
	@Autowired
	RestTemplate restTemplate;


	@RequestMapping(value = "/hello-dash", method = RequestMethod.GET)
	public String helloConsumer() {
		return restTemplate.getForEntity("http://localhost:9000/ribbon-consumer", String.class).getBody();
	}

}
