package com.zxin.di13;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest {
	
	@Test
	public void test01() {
		/*
		String resource = "applicationContext13-base.xml";
		String resource2 = "applicationContext13-beans.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource, resource2);
		*/
//
//		String resource = "applicationContext13-base.xml";
//		String resource2 = "applicationContext13-beans.xml";
//		String[] resources = {resource, resource2};
//		ApplicationContext ac = new ClassPathXmlApplicationContext(resources);

		String resource = "applicationContext13-*.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		
		Student student = (Student) ac.getBean("myStudent");
		System.out.println(student);

		Teacher teacher = (Teacher) ac.getBean("myTeacher");
		System.out.println(teacher);
	}
	
}



















