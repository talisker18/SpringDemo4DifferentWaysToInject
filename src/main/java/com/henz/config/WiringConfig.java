package com.henz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.henz.SpringDemo4DifferentWaysToInjectApplication;
import com.henz.beans.SomeBean2;

@Configuration

//this will be overwritten by config in SpringDemo4DifferentWaysToInjectApplication
@ComponentScan(basePackages = "com.henz.beans")
public class WiringConfig {
	
	@Bean
	public SomeBean2 getSomeBean2() {
		return new SomeBean2();
	}

}
