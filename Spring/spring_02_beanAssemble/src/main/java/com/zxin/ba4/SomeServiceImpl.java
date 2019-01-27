package com.zxin.ba4;

public class SomeServiceImpl implements ISomeService {
	private int a;
	
	public SomeServiceImpl() {
		System.out.println("ba4 执行无参构造器");
	}
	
	/*
	public SomeServiceImpl(int a) {
		this.a = a;
	}
	*/
	
	@Override
	public void doSome() {
		System.out.println("ba4 执行doSome()方法");
	}

}
