package com.zxin.ba1;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest {
	
	@Test
	public void test01() {
		String resource = "applicationContext1.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		ISomeService service = (ISomeService) ac.getBean("myService");
		service.doSome();
	}
}



















