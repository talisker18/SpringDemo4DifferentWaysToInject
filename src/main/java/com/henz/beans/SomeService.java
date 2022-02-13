package com.henz.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henz.beans_to_exclude.SomeBean4;

@Service
public class SomeService {
	
	//@Autowired
	//private SomeBean4 someBean4; --> this will throw an exception because someBean4 is not in scanned packages
	//(package of someBean4 = com.henz.beans_to_exclude)
	
	/*public String doSomethinWithBean4() {
		String str=this.someBean4.hello("joel");
		return str;
	}*/
	
	//autowiring does same as using context.getBean....
	
	@Autowired
	private SomeBean someBean;
	
	@Autowired
	private SomeBean2 someBean2;
	
	@Autowired
	private SomeBean3 someBean3; //injecting works even SomeBean3 has no @Component. this because the bean is defined through @Bean in SpringDemo4DifferentWaysToInjectApplication
	//and therefore the ComponentScan finds this bean
	
	//@Autowired
	//private SomeBean4 someBean4; --> cannot be injected because it is excluded in the ComponentScan
	
	@Autowired
	private SomeBean5 someBean5;
	
	public void doSomething() {
		System.out.println("do something from SomeService...printing outputs of beans:");
		System.out.println("----------------");
		System.out.println("SomeBean: "+this.someBean.hello("service"));
		System.out.println("SomeBea2: "+this.someBean2.hello("service"));
		System.out.println("SomeBean3: "+this.someBean3.hello("service"));
		//System.out.println("SomeBean4: "+this.someBean4.hello("service"));
		System.out.println("SomeBean5: "+this.someBean5.hello("service"));
		
		System.out.println("----------------");
	}
	

}
