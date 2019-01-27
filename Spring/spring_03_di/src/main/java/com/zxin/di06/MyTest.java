package com.zxin.di06;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest {
	
	@Test
	public void test01() {
		// 创建容器对象，加载Spring配置文件
		String resource = "applicationContext5.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		MyCollection collection = (MyCollection) ac.getBean("myCollection");
		System.out.println(collection);
	}
	
}



















