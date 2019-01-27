package com.zxin.aop13;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest {
	
	@Test
	public void test01() {
		// 创建容器对象，加载Spring配置文件
		String resource = "applicationContext13.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		ISomeService service = (ISomeService) ac.getBean("someService");
		service.doFirst();
		System.out.println("==================");
		service.doSecond();
		System.out.println("==================");
		service.doThird();
		
		System.out.println("-----------------------------");
		
		ISomeService service2 = (ISomeService) ac.getBean("someService2");
		service2.doFirst();
		System.out.println("==================");
		service2.doSecond();
		System.out.println("==================");
		service2.doThird();
	}
	
}



















