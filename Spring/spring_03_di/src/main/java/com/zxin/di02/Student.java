package com.zxin.di02;

public class Student {
	private String name;
	private int age;
	private School school;   // 对象属性，域属性

	/**注意这里不需要加上　无参数构造器也是可以的 **/


	public Student(String name, int age, School school) {
		super();
		this.name = name;
		this.age = age;
		this.school = school;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", school=" + school
				+ "]";
	}
}
