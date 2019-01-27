package com.zxin.ba4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest {
	
	@Test
	public void test01() {
		String resource = "applicationContext4.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);

		// 如果是单例模式，就会输出true ,如果是原型模式，就会输出false
		ISomeService service = (ISomeService) ac.getBean("myService");
		ISomeService service2 = (ISomeService) ac.getBean("myService");
		System.out.println("service == service2  " + (service == service2));
	}
	
}



















