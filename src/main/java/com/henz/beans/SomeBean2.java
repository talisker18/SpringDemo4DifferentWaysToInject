package com.henz.beans;

import org.springframework.stereotype.Component;

@Component("someBean2")
public class SomeBean2 {
	
	public String hello(String name) {
		return "hello "+name+" from SomeBean2.class";
	}

}
