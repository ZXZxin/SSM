package com.zxin.resolvers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zxin.exceptions.AgeException;
import com.zxin.exceptions.NameException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("ex", ex);
		mv.setViewName("/errors/error.jsp");
		
		if(ex instanceof NameException) {
			// 执行一些操作
			mv.setViewName("/errors/nameError.jsp");
		}
		
		if(ex instanceof AgeException) {
			// 执行一些操作
			mv.setViewName("/errors/ageError.jsp");
		}
		
		return mv;
	}

}
