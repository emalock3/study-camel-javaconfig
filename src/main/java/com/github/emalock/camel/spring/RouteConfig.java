package com.github.emalock.camel.spring;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.SpringCamelContext;
import org.apache.camel.spring.javaconfig.Main;
import org.apache.camel.spring.javaconfig.SingleRouteCamelConfiguration;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig extends SingleRouteCamelConfiguration implements
		InitializingBean {

	public static void main(String... args) throws Exception {
		Main main = new Main();
		main.enableHangupSupport();
		main.start();
		ProducerTemplate template = main.getCamelTemplate();
		System.out.println("\n======================\n");
		template.requestBody("direct:hello", "hoge");
		System.out.println("\n======================\n");
		main.stop();
	}
	
	@Override
	protected CamelContext createCamelContext() throws Exception {
		return new SpringCamelContext(getApplicationContext());
	}

	public static class Greet {
		public void sayHello(String name) {
			System.out.println("Hello " + name);
		}
	}

	@Bean
	@Override
	public RouteBuilder route() {
		return new RouteBuilder() {
			public void configure() {
				from("direct:hello").bean(new Greet());
			}
		};
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// do nothing
	}

}
