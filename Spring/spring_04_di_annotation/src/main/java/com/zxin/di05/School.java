package com.zxin.di05;

public class School {
	private String name;

	public School() {
		super();
	}

	public School(String name) {
		super();
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "School [name=" + name + "]";
	}
}
