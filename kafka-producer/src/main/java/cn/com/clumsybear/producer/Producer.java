package cn.com.clumsybear.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import com.alibaba.fastjson.JSONObject;

import cn.com.clumsybear.bean.User;

@Component
@EnableScheduling
public class Producer {
	private static final Logger LOG = LoggerFactory.getLogger(Producer.class);
	private static final String topic = "inv-auth-result";
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	@Autowired
	Service service;

	
	public void send() {
		String message = "Hello World---" + System.currentTimeMillis();

		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("user-test-20partition", message);
		future.addCallback(success -> service.mothod1(), fail -> service.mothod2());
	}

	// @Scheduled(cron = "0/5 * * * * ?")
	@Scheduled(fixedDelay = 60 * 60 * 1000)
	
	public void sendUser() {
		int i = 0;
		while (true) {
			User user = new User();
			user.setId("id:" + i);
			user.setName("name:" + i++);
			String userString = JSONObject.toJSONString(user);
			System.out.println(userString);

			ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("user-test-20partition", userString);
			future.addCallback(success -> LOG.info("Kafka Producer 发送消息成功！"),
					fail -> LOG.error("Kafka Producer 发送消息失败！"));
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
