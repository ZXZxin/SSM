package com.zxin.ba6;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	// bean：表示当前正在进行初始化的Bean对象
	// beanName：表示当前正在进行初始化的Bean对象的id
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("Step5：执行 ----before---()方法");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(final Object bean, String beanName)
			throws BeansException {
		System.out.println("Step8：执行 ----after---()方法");
		return bean;
	}

}
