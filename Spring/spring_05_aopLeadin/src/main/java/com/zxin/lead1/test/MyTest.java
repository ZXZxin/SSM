package com.zxin.lead1.test;


import com.zxin.lead1.service.ISomeService;
import com.zxin.lead1.service.SomeServiceImpl;

public class MyTest {

	public static void main(String[] args) {
		ISomeService service = new SomeServiceImpl();
		service.doFirst();
		System.out.println("==============");
		service.doSecond();
	}

}
