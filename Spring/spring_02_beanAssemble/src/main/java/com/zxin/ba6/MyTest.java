package com.zxin.ba6;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest {
	
	@Test
	public void test01() {
		// 创建容器对象，加载Spring配置文件
		String resource = "applicationContext6.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		ISomeService service = (ISomeService) ac.getBean("myService");
		service.doSome();

		// 对于销毁方法的执行，有两个条件：
		//    1)当前的Bean需要是singleton的
		//    2)要手工关闭容器
		((ClassPathXmlApplicationContext)ac).close();
	}
	
}



















