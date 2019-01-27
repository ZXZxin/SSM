package com.zxin.ba5;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest {
	
	@Test
	public void test01() {
		String resource = "applicationContext5.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);

		// 下面是MyService的doSome增强，doOther不增强，MyService2都不增强

		ISomeService service = (ISomeService) ac.getBean("myService");
		System.out.println(service.doSome());
		System.out.println(service.doOther());
		
		System.out.println("======================");
		
		ISomeService service2 = (ISomeService) ac.getBean("myService2");
		System.out.println(service2.doSome());
		System.out.println(service2.doOther());
	}
	
}



















