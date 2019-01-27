package com.zxin.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class PermissionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response, Object handler) throws Exception {
		System.out.println("执行PermissionInterceptor ---- preHandle() ------");
		
		String user = (String) request.getSession().getAttribute("user");
		if("zxzxin".equals(user)) {
			return true;
		}
		request.getRequestDispatcher("/fail.jsp").forward(request, response);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request,
						   HttpServletResponse response, Object handler,
						   ModelAndView modelAndView) throws Exception {
		System.out.println("执行PermissionInterceptor ---- postHandle() ------");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
								HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("执行PermissionInterceptor ---- afterCompletion() ------");
	}

}
