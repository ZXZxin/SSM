package com.zxin.test;

import com.zxin.service.ISomeService;
import com.zxin.service.SomeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;


public class MyTest {
	
	@Test
	public void test01() {
		ISomeService service = new SomeServiceImpl();
		service.doSome();
	}
	
	@Test
	public void test02() {
		// 创建容器对象，加载Spring配置文件, 会从类路径下查找配置文件
		ApplicationContext ac  = new ClassPathXmlApplicationContext("applicationContext.xml");
		ISomeService service = (ISomeService) ac.getBean("myService");
		service.doSome();
	}

	// 下面两种用的少
	@Test
	public void test03() {
		// 创建容器对象，加载Spring配置文件, 会从项目的根下查找配置文件
		ApplicationContext ac = new FileSystemXmlApplicationContext(
				"/home/zxzxin/IDEA/SSM/Spring/spring_01_primary/src/main/resources/applicationContext.xml");
		ISomeService service = (ISomeService) ac.getBean("myService");
		service.doSome();
	}
	
	@Test
	public void test04() {
		// 创建容器对象，加载Spring配置文件, 会从当前文件系统的D盘根目录下查找配置文件
  		ApplicationContext ac = new FileSystemXmlApplicationContext("d:/applicationContext.xml");
		ISomeService service = (ISomeService) ac.getBean("myService");
		service.doSome();
	}
	
//	 ApplicationContext与BeanFactory容器的区别：
//	 这两上容器对于其中Bean的创建时机不同：
//	 1）ApplicationContext容器在进行初始化时，会将其中的所有Bean(对象)进行创建
//	    缺点：占用系统资源（内存、CPU等）
//	    优点：响应速度快
//	 2）BeanFactory容器中的对象，在容器初始化时并不会被创建，而是在真正获取该对象时才被创建
//	    缺点：相对来说，响应速度慢
//	    优点：不多占用系统资源

	@Test
	public void test05() {
		// 创建BeanFactory容器 这个方法不推荐使用，已经过时了
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		ISomeService service = (ISomeService) bf.getBean("myService");
		service.doSome();
	}
	
}



















