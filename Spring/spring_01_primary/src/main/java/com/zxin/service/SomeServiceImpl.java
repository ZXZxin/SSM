package com.zxin.service;

public class SomeServiceImpl implements ISomeService {
	// private int a = 5;
	
	// 一个没有成员变量的对象在堆内存中占有8个字节
	// Object obj = new Object();
	
	// 动态代码块
	/*{
		System.out.println("执行动态代码块 a = " + a);
	}*/
	
	public SomeServiceImpl() {
		System.out.println("执行无参构造器");
	}

	@Override
	public void doSome() {
		System.out.println("执行doSome()方法");
	}

}
