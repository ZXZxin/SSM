package com.zxin.ba6;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class SomeServiceImpl implements ISomeService, BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {
	private String adao;
	private String bdao;
	
	public void setAdao(String adao) {
		this.adao = adao;
		System.out.println("Step2：执行setter");
	}

	public void setBdao(String bdao) {
		this.bdao = bdao;
		System.out.println("Step2：执行setter");
	}

	public SomeServiceImpl() {
		System.out.println("Step1：执行无参构造器");
	}
	
	@Override
	public void doSome() {
		System.out.println("Step9：执行doSome()方法");
	}

	public void setUp() {
		System.out.println("Step7：初始化完毕之后");
	}
	
	public void tearDown() {
		System.out.println("Step11：销毁之前");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("Step3：获取到bean的id = " + name);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("Step4：获取到BeanFactory容器");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Step6：Bean初始化完毕了");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Step10：实现接口的销毁之前");
	}

}








