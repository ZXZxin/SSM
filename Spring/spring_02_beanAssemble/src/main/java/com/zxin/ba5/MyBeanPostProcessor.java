package com.zxin.ba5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	// bean：表示当前正在进行初始化的Bean对象
	// beanName：表示当前正在进行初始化的Bean对象的id
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("执行 ----before---()方法");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(final Object bean, String beanName)
			throws BeansException {
		System.out.println("执行 ----after---()方法");
		//增强 -- JDK动态代理
		if ("myService".equals(beanName)) {
			Object obj = Proxy.newProxyInstance(bean.getClass()
					.getClassLoader(), bean.getClass().getInterfaces(),
					new InvocationHandler() {

						@Override
						public Object invoke(Object proxy, Method method,
								Object[] args) throws Throwable {
							Object invoke = method.invoke(bean, args);
							if ("doSome".equals(method.getName())) { // 只增强 doSome，不增强doOther方法
								return ((String) invoke).toUpperCase();
							}
							return invoke;
						}
					});
			return obj;
		}
		return bean;
	}

}
