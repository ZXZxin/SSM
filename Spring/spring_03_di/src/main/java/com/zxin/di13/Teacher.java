package com.zxin.di13;

public class Teacher {
	private String name;
	private int workAge; // 工龄
	private String school; // 学校
	private String department; // 院系

	public void setName(String name) {
		this.name = name;
	}

	public void setWorkAge(int workAge) {
		this.workAge = workAge;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", workAge=" + workAge + ", school="
				+ school + ", department=" + department + "]";
	}
}
