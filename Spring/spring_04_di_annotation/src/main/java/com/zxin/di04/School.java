package com.zxin.di04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Component("mySchool")    // 组件，表示当前类被Spring容器所管理
public class School {
	@Value("清华大学")
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "School [name=" + name + "]";
	}
}
