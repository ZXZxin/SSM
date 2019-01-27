package com.zxin.di11;

public class Student {
	private String name;
	private int age;
	private String school; // 学校
	private String department; // 院系

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", school=" + school
				+ ", department=" + department + "]";
	}
}
