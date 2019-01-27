package com.zxin.di10;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest {
	
	@Test
	public void test01() {
		// 创建容器对象，加载Spring配置文件
		String resource = "applicationContext10.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		
		Student student = (Student) ac.getBean("myStudent");
		System.out.println(student);

		// 因为School是内部bean，所以下面获取不到
//		School school = (School) ac.getBean("mySchool");
//		System.out.println(school);
	}
	
}



















