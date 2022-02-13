package com.henz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.henz.beans.SomeBean;
import com.henz.beans.SomeBean2;
import com.henz.beans.SomeBean3;
import com.henz.beans.SomeBean5;
import com.henz.beans.SomeService;
import com.henz.beans_to_exclude.SomeBean4;

/**
 * Spring needs to know which packages to scan for annotated components in order to add them to the IoC container. 
 * In a Spring Boot project, we typically set the main application class with the @SpringBootApplication annotation. 
 * Under the hood, @SpringBootApplication is a composition of the @Configuration, @ComponentScan, and @EnableAutoConfiguration 
 * annotations. With this default setting, Spring Boot will auto scan for components in the current package 
 * (containing the @SpringBoot main class) and its sub packages.
 * 
 * 
 * 
 * */

/*
 * comment by me: so in my case, the WiringConfig with its ComponentScan is ignored because the ComponentScan of SpringDemo4DifferentWaysToInjectApplication
 * is used....so lets do the excluding of packages here
 * 
 * */
@Configuration
//we want to exclude beans of package com.henz.beans_to_exclude
@ComponentScan(basePackages = "com.henz.beans")
@SpringBootApplication
public class SpringDemo4DifferentWaysToInjectApplication {
	
	@Bean("someBean3")
	//must be public!!!
	public SomeBean3 getSomeBean3() {
		return new SomeBean3();
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringDemo4DifferentWaysToInjectApplication.class);
		ConfigurableApplicationContext context = app.run(args);
		
		String str;
		
		//get bean by @Component annotation of SomeBean.class. use only the class because bean does not have a name
		str = context.getBean(SomeBean.class).hello("joel");
		System.out.println(str);
		
		//get bean by @Component annotation of SomeBean2.class. use name and class
		//if we do not use the name, bean will not be found
		str = context.getBean("someBean2",SomeBean2.class).hello("joel");
		System.out.println(str);
		
		//inject bean SomeBean3 by using @Bean + getter in this class instead of @Component in SomeBean3.class. Important: use public modifier for getter method
		//str = context.getBean("someBean3",SomeBean3.class).hello("joel");
		//System.out.println(str);
		
		//System.out.println(context.containsBeanDefinition(SomeBean.class)); //cannot use this here because SomeBean does not have a name by String
		System.out.println(context.containsBeanDefinition("someBean2")); //will print true
		System.out.println(context.containsBeanDefinition("someBean3")); //will print true
		System.out.println(context.containsBeanDefinition("someBean4")); //will print false because this bean is not scanned
		
		//now we get a bean that does not have @Component and is not configured in this class with @Bean, but it is configured in
		//BeanContainer class. there, we have to annotate again with @Configuration. as we see, we can have multiple classes with @Configuration
		str = context.getBean("someBean5",SomeBean5.class).hello("joel");
		System.out.println(str);
		System.out.println();
		System.out.println();
		
		
		/*
		 * now get bean of @Service
		 * 
		 * */
		context.getBean(SomeService.class).doSomething();
		
	}

}
