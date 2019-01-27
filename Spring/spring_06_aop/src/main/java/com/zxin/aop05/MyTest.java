package com.zxin.aop05;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest {
	
	@Test
	public void test01() throws UserException {
		String resource = "applicationContext5.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		ISomeService service = (ISomeService) ac.getBean("serviceProxy");
//		service.login("zxin", "root"); // 正常
		service.login("zxin", "rootaaa"); // 密码异常
		service.login("zxinzzz", "root"); // 用户名异常
	}
}



















