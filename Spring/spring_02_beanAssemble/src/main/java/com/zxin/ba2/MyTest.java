package com.zxin.ba2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest {
	
	@Test
	public void test01() {
		ISomeService service = new ServiceFactory().getSomeService();
		service.doSome();
	}


	//使用Spring创建
	@Test
	public void test02() {
		String resource = "applicationContext2.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		ISomeService service = (ISomeService) ac.getBean("myService");
		service.doSome();
	}
	
}



















