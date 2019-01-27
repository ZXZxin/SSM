package com.zxin.aop05;

// 主业务接口
public interface ISomeService {
	// 目标方法
	boolean login(String username, String password) throws UserException;
}
