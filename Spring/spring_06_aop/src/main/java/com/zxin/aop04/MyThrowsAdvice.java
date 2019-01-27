package com.zxin.aop04;

import org.springframework.aop.ThrowsAdvice;

// 异常通知
public class MyThrowsAdvice implements ThrowsAdvice {
	
	// 当目标方法抛出与指定类型的异常具有is-a关系的异常时，执行当前方法
	public void afterThrowing(Exception ex) {
		System.out.println("执行异常通知方法" + ex.getMessage());
	}
}
