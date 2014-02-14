package com.github.emalock.camel.spring;

import org.apache.camel.Consume;
import org.springframework.stereotype.Component;

@Component
public class Foo implements IFoo {
	
	@Consume(uri = CONSUME_URI)
	public void foo(String s) {
		System.out.println("foo " + s);
	}
}
