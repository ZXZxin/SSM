package com.zxin.xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest {
	
	@Test
	public void test01() {
		String resource = "applicationContextXML.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		
		ISomeService service = (ISomeService) ac.getBean("someService");
		service.doFirst();
		System.out.println("----------------------------");
		service.doSecond();
		System.out.println("----------------------------");
		service.doThird();
	}
	
}



















