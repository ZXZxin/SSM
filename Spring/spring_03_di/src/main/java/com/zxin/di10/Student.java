package com.zxin.di10;

public class Student {
	private String name;
	private int age;
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
