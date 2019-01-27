package com.zxin.di01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// Scope和xml配置中的是差不多的
// @Scope("prototype")   // 默认也是singleton
@Component("myStudent")
public class Student {

	@Value("张三")
	private String name;
	@Value("23")
	private int age;

	@Autowired     // byType方式的注解式注入
	private School school;   // 对象属性，域属性
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", school=" + school
				+ "]";
	}
}
