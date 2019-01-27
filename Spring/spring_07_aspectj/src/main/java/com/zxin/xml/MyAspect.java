package com.zxin.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

// 切面
public class MyAspect {
	
	public void myBefore() {
		System.out.println("执行前置通知方法");
	}
	
	public void myBefore(JoinPoint jp) {
		System.out.println("执行前置通知方法 jp = " + jp);
	}
	
	public void myAfterReturning() {
		System.out.println("执行后置通知方法");
	}
	
	public void myAfterReturning(Object result) {
		System.out.println("执行后置通知方法  result = " + result);
	}
	
	public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("执行环绕通知方法, 目标方法执行之前");
		// 执行目标方法
		Object result = pjp.proceed();
		System.out.println("执行环绕通知方法, 目标方法执行之后");
		if(result != null) {
			result = ((String)result).toUpperCase();
		}
		return result;
	}
	
	public void myAfterThrowing() {
		System.out.println("执行异常通知方法");
	}
	
	public void myAfterThrowing(Exception ex) {
		System.out.println("执行异常通知方法 ex = " + ex.getMessage());
	}
	
	public void myAfter() {
		System.out.println("执行最终通知方法");
	}
	
}




























