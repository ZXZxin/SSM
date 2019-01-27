package com.zxin.test;

import java.util.List;

import com.zxin.beans.Student;
import com.zxin.service.IStudentService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest {
	
	private IStudentService service;

	@Before
	public void before() {
		// 创建容器对象，加载Spring配置文件
		String resource = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		service = (IStudentService) ac.getBean("studentService");
	}
	
	@Test
	public void test01() {
		Student student = new Student("张三", 23);
		service.addStudent(student);
	}
	
	@Test
	public void test02() {
		service.removeById(2);
	}
	
	@Test
	public void test03() {
		Student student = new Student("张三", 23);
		student.setId(3);
		service.modifyStudent(student);
	}
	
	@Test
	public void test04() {
		List<String> names = service.findAllStudentsNames();
		System.out.println(names);
	}
	
	@Test
	public void test05() {
		String name = service.findStudentNameById(3);
		System.out.println(name);
	}
	
	@Test
	public void test06() {
		List<Student> students = service.findAllStudents();
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	@Test
	public void test07() {
		Student student = service.findStudentById(3);
		System.out.println(student);
	}
}



















