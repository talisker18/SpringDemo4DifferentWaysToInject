package com.henz.beans;

import org.springframework.stereotype.Component;

@Component
public class SomeBean {
	
	public String hello(String name) {
		return "hello "+name+" from SomeBean.class";
	}

}
