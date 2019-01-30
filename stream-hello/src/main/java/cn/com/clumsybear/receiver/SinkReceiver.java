package cn.com.clumsybear.receiver;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Headers;

@EnableBinding(Sink.class)
public class SinkReceiver {
	private Logger logger = LoggerFactory.getLogger(SinkReceiver.class);
	
	@StreamListener(Sink.INPUT)
	public void receive(Object payload,@Headers Map head) {
		logger.info("Received : " + payload);
		logger.info("header : "+head.get("ttt"));

	}

}
