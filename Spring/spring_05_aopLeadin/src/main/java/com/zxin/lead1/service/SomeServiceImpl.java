package com.zxin.lead1.service;


import com.zxin.lead1.utils.SystemService;

public class SomeServiceImpl implements ISomeService {

	@Override
	public void doFirst() {
		SystemService.doTx();
		System.out.println("执行doFirst()方法");
		SystemService.doLog();
	}

	@Override
	public void doSecond() {
		SystemService.doTx();
		System.out.println("执行doSecond()方法");
		SystemService.doLog();
	}
}
















