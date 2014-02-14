package com.github.emalock.camel.spring;

import org.apache.camel.Consume;
import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Greet {
	
	@Produce(uri = Foo.CONSUME_URI)
	protected IFoo foo;
	
	@EndpointInject(uri = Bar.URI)
	protected ProducerTemplate barTemplate;
	
	@Autowired
	protected Hoge hoge;
	
	@Consume(uri="direct:greet")
	public void sayHello(String name) {
		System.out.println("Hello " + name);
		foo.foo(name);
		barTemplate.sendBody(name);
		hoge.hoge(name);
	}
}
