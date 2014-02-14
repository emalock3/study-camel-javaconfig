package com.github.emalock.camel.spring;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.javaconfig.Main;
import org.apache.camel.spring.javaconfig.SingleRouteCamelConfiguration;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig extends SingleRouteCamelConfiguration implements InitializingBean {

	public static void main(String... args) throws Exception {
		Main main = new Main();
		main.setConfigClassesString(RouteConfig.class.getName());
		main.setBasedPackages(RouteConfig.class.getPackage().getName());
		main.start();
		ProducerTemplate template = main.getCamelTemplate();
		System.out.println("\n======================\n");
		template.requestBody("direct:hello", "hoge");
		template.requestBody("direct:hoge3", "hoge3");
		System.out.println("\n======================\n");
		main.stop();
	}

	@Bean
	@Override
	public RouteBuilder route() {
		return new RouteBuilder() {
			public void configure() {
				from("direct:hello").to("direct:greet");
			}
		};
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// do nothing
	}

}
