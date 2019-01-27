package com.zxin.di11;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest {
	
	@Test
	public void test01() {
		String resource = "applicationContext11.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		
		Student student = (Student) ac.getBean("myStudent");
		System.out.println(student);
		Student student2 = (Student) ac.getBean("myStudent2");
		System.out.println(student2);
		Student student3 = (Student) ac.getBean("myStudent3");
		System.out.println(student3);
		/*
		Student baseStudent = (Student) ac.getBean("baseStudent");
		System.out.println(baseStudent);
		*/
	}
	
}



















