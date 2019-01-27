package com.zxin.ba2;

public class ServiceFactory {
	public ISomeService getSomeService() {
		return new SomeServiceImpl();
	}
}
