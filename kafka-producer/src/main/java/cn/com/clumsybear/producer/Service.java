package cn.com.clumsybear.producer;

import org.springframework.stereotype.Component;

@Component
public class Service {
	public void mothod1() {
		System.out.println("success!");
	}
	public void mothod2() {
		System.out.println("error!");
	}
}
