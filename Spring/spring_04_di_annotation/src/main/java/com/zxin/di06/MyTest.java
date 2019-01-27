package com.zxin.di06;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext6.xml")
public class MyTest {

	//byname 方式
	@Autowired
	@Qualifier("myStudent")
	private Student student;
	
	@Autowired
	@Qualifier("mySchool")
	private School school;
	
	@Test
	public void test01() {
		System.out.println(student);
	}
	
	@Test
	public void test02() {
		System.out.println(school);
	}
	
}



















