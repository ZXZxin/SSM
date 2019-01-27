package com.zxin.aop05;

import org.springframework.aop.ThrowsAdvice;

// 异常通知
public class MyThrowsAdvice implements ThrowsAdvice {
	
	// 当目标方法抛出UsernameException异常时，执行当前方法
	public void afterThrowing(UsernameException ex) {
		System.out.println("发生用户名异常 ex = " + ex.getMessage());
	}
	
	// 当目标方法抛出PasswordException异常时，执行当前方法
	public void afterThrowing(PasswordException ex) {
		System.out.println("发生密码异常 ex = " + ex.getMessage());
	}
	
	// 当目标方法抛出其它异常时，执行当前方法
	public void afterThrowing(Exception ex) {
		System.out.println("发生异常 ex = " + ex.getMessage());
	}
	
}
