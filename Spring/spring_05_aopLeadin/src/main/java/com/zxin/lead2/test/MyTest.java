package com.zxin.lead2.test;

import com.zxin.lead2.service.ISomeService;
import com.zxin.lead2.service.SomeServiceImpl;
import com.zxin.lead2.utils.SystemService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyTest {

	public static void main(String[] args) {
		final ISomeService target = new SomeServiceImpl();
		ISomeService service = (ISomeService) Proxy.newProxyInstance(
								target.getClass().getClassLoader(), 
								target.getClass().getInterfaces(), 
								new InvocationHandler() {
									// 织入 weaving
									@Override
									public Object invoke(Object proxy, Method method, Object[] args)
											throws Throwable {
										SystemService.doTx();
										// 执行目标方法
										Object result = method.invoke(target, args);
										SystemService.doLog();
										return result;
									}
								});
		service.doFirst();
		System.out.println("==============");
		service.doSecond();
	}

}
