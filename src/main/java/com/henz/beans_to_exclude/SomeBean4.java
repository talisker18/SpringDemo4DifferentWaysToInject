package com.henz.beans_to_exclude;

import org.springframework.stereotype.Component;

@Component("someBean4")
public class SomeBean4 {
	
	public String hello(String name) {
		return "hello "+name+" from SomeBean4.class";
	}

}
