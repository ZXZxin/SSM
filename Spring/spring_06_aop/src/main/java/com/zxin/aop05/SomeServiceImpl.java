package com.zxin.aop05;

// 目标类
public class SomeServiceImpl implements ISomeService {

	@Override
	public boolean login(String username, String password) throws UserException {
		if(!"zxin".equals(username)) {
			throw new UsernameException("用户名输错了！");
		}
		if(!"root".equals(password)) {
			throw new PasswordException("密码输错了！");
		}
		// double a = 3 / 0; // 其他异常
		return true;
	}

}
















