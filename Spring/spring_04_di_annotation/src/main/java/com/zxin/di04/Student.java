package com.zxin.di04;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// @Scope("prototype")   // 默认也是singleton
@Component("myStudent")
public class Student {
	@Value("张三")
	private String name;
	@Value("23")
	private int age;
	
	// @Resource(name="mySchool")   // byName方式的注解式注入
	@Resource   // byType方式的注解式注入
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
	
	@PostConstruct
	public void initAfter() {
		System.out.println("当前Bean初始化刚完毕");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("当前Bean即将被销毁");
	}
	
}






















