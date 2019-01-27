package com.zxin.handlers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller    
@RequestMapping("/zxin")
public class MyController {

	@RequestMapping("/register.do")
	public ModelAndView doRegister(int age, Date birthday) {
		System.out.println("age  =  " + age);
		System.out.println("birthday  =  " + birthday);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("birthday", birthday);
		mv.addObject("age", age);
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}

	//数据回显示(使用request.getParameter)　以及　显示哪一项出错（getMessage中判断(contains)）
	@ExceptionHandler(TypeMismatchException.class)
	public ModelAndView exceptionResolver(HttpServletRequest request, Exception ex) {
		ModelAndView mv = new ModelAndView();
		
		String age = request.getParameter("age");
		String birthday = request.getParameter("birthday");
		
		// 捕获到的异常信息
		String errorMSG = ex.getMessage();
		if(errorMSG.contains(age)) {
			mv.addObject("ageErrors", "年龄输入有误");
		}
		if(errorMSG.contains(birthday)) {
			mv.addObject("birthErrors", "日期输入有误");
		}
		
		mv.addObject("age", age);
		mv.addObject("birthday", birthday);
		mv.addObject("ex", ex);
		mv.setViewName("/index.jsp");
		return mv;
	}
}


















