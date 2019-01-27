package com.zxin.test;

import com.zxin.service.BuyStockException;
import com.zxin.service.IBuyStockService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
	
	private IBuyStockService service;

	@Before
	public void before() {
		// 创建容器对象，加载Spring配置文件
		String resource = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		service = (IBuyStockService) ac.getBean("buyStockService"); //注意这里直接获取原来的目标对象，没有代理对象了
	}
	
	@Test
	public void test01() {
		service.openAccount("张三", 10000);
		service.openStock("百度", 0);
	}
	
	@Test
	public void test02() throws BuyStockException {
		service.buyStock("张三", 100, "百度", 5);
	}
}



















