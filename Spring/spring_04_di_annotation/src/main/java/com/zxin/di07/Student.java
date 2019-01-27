package com.zxin.di07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// @Scope("prototype")   // 默认也是singleton
@Component("myStudent")
public class Student {
	@Value("张大三")
	private String name;
	@Value("23")
	private int age;
	
	@Autowired     // byType方式的注解式注入
	private School school;   // 对象属性，域属性
	
	public void setName(String name) {
		System.out.println("执行setName()");
		this.name = name;
	}
	public void setAge(int age) {
		System.out.println("执行setAge()");
		this.age = age;
	}
	
	public void setSchool(School school) {
		this.school = school;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", school=" + school
				+ "]";
	}
}
