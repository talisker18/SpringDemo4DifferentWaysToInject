package com.henz.beans;

//configured as @Bean in BeanContainer
public class SomeBean5 {

	public String hello(String name) {
		return "hello "+name+" from SomeBean5.class";
	}
}
