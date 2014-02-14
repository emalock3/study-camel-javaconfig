package com.github.emalock.camel.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Hoge {

	private final HogeHoge hogehoge;
	
	@Autowired
	public Hoge(HogeHoge hogehoge) {
		this.hogehoge = hogehoge;
	}
	
	public void hoge(String name) {
		System.out.println("hoge " + name);
		hogehoge.hogehoge();
	}
}
