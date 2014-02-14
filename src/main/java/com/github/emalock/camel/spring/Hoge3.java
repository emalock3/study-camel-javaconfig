package com.github.emalock.camel.spring;

import org.apache.camel.Consume;
import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Component;

@Component
public class Hoge3 {
	@EndpointInject(uri="direct:greet")
	ProducerTemplate producer;
	
	@Consume(uri="direct:hoge3")
	public void hoge3(String message) {
		producer.sendBody("hoge3");
	}
}
