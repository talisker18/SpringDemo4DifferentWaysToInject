package com.henz.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanContainer {
	
	@Bean("someBean5")
	//must be public!!!
	public SomeBean5 getSomeBean5() {
		return new SomeBean5();
	}

}
