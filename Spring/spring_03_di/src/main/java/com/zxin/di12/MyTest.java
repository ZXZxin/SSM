package com.zxin.di12;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
	
	@Test
	public void test01() {
		// 创建容器对象，加载Spring配置文件
		String resource = "applicationContext12.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		
		Student student = (Student) ac.getBean("myStudent");
		System.out.println(student);
		
		Teacher teacher = (Teacher) ac.getBean("myTeacher");
		System.out.println(teacher);
	}
	
}



















