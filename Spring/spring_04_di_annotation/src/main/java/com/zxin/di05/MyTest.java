package com.zxin.di05;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest {
	
	@Test
	public void test01() {
		String resource = "applicationContext5.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		Student student = (Student) ac.getBean("myStudent");
		System.out.println(student);
	}
	
}



















