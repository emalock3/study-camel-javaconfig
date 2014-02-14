package com.github.emalock.camel.spring;

import org.apache.camel.Consume;
import org.springframework.stereotype.Component;

@Component
public class Bar {

	static final String URI = "direct:bar";
	
	@Consume(uri = URI)
	public void bar(String name) {
		System.out.println("bar " + name);
	}
}
