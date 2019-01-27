package com.zxin.aop01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest {
	
	@Test
	public void test01() {
		String resource = "applicationContext1.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		ISomeService service = (ISomeService) ac.getBean("serviceProxy"); // 注意获取的是代理的，而不是原来的
		service.doFirst();
		System.out.println("==================");
		service.doSecond();
	}
	
}



















