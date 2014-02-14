package com.github.emalock.camel.spring;

public interface IFoo {
	String CONSUME_URI = "direct:foo";
	void foo(String s);
}
