package com.zxin.ba3;

public class ServiceFactory {
	public static ISomeService getSomeService() {
		return new SomeServiceImpl();
	}
}
