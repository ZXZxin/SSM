package com.zxin.aop04;

// 目标类
public class SomeServiceImpl implements ISomeService {

	@Override
	public void doFirst() {
		System.out.println("执行doFirst()方法" + 3 / 0);
	}

	@Override
	public String doSecond() {
		System.out.println("执行doSecond()方法");
		return "abcde";
	}
}
















