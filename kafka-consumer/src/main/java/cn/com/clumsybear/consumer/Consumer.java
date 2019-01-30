package cn.com.clumsybear.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import cn.com.clumsybear.bean.User;

@Component
public class Consumer {
	private static final Logger LOG = LoggerFactory.getLogger(Consumer.class);
	@Autowired
	Service service;

	@KafkaListener(topics = "user-test-20partition")
	public void receive(@Payload String message, @Headers MessageHeaders headers) {
		// LOG.info("Kafka Consumer 接收到消息：" + message);
		// headers.keySet().forEach(key -> LOG.info("{}: {}", key, headers.get(key)));

		User user = JSONObject.parseObject(message, User.class);
		System.out.println(user.getId());
		System.out.println(user.getName());
		if (Math.random() < 0.5) {
			service.send(user);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
