package com.zxin.aop11;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

// 后置通知：可以获取到目标方法的返回结果，但无法改变目标方法的结果
public class MyAfterReturningAdvice implements AfterReturningAdvice {

	// 在目标方法执行之后执行
	// returnValue：目标方法的返回值
	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		System.out.println("执行后置通知方法  returnValue = " + returnValue);
	}

}
