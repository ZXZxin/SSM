package com.zxin.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest {
	
	@Test
	public void test01() {
		String resource = "applicationContextAnnotation.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		
		ISomeService service = (ISomeService) ac.getBean("someService"); //注意这里直接用目标对象，因为没有代理对象
		service.doFirst();
		System.out.println("----------------------------");
		service.doSecond();
		System.out.println("----------------------------");
		service.doThird();
	}
	
}



















