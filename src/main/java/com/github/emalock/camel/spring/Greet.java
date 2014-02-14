package com.github.emalock.camel.spring;

import org.apache.camel.Consume;
import org.springframework.stereotype.Component;

@Component
public class Greet {
	
	@Consume(uri="direct:greet")
	public void sayHello(String name) {
		System.out.println("Hello " + name);
	}
}
