package com.zxin.di01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


// 与@Component注解功能相同，但意义不同的注解还有三个：
	// 1)@Repository：注解在Dao实现类上
	// 2)@Service：注解在Service实现类上
	// 3)@Controller：注解在SpringMVC的处理器上

@Component("mySchool")    // 组件，表示当前类被Spring容器所管理
public class School {

	@Value("清华大学")  // 注入属性
	private String name;

	@Override
	public String toString() {
		return "School [name=" + name + "]";
	}
}
