package cn.com.clumsybear.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import com.alibaba.fastjson.JSONObject;

import cn.com.clumsybear.bean.User;

@Component
public class Service {
	private static final Logger LOG = LoggerFactory.getLogger(Service.class);
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void send(User user) {
		String userString = JSONObject.toJSONString(user);
		System.out.println(userString);

		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("user-test-20partition", userString);
		future.addCallback(success -> LOG.info("Kafka Producer 发送消息成功！"), fail -> LOG.error("Kafka Producer 发送消息失败！"));
	}

}
