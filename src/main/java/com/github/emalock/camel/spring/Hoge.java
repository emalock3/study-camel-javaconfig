package com.github.emalock.camel.spring;

import org.springframework.stereotype.Component;

@Component
public class Hoge {

	public void hoge(String name) {
		System.out.println("hoge " + name);
	}
}
