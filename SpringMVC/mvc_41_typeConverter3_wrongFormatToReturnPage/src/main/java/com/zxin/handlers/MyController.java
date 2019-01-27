package com.zxin.handlers;

import java.util.Date;

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
		System.out.println("age  =   " + age);
		System.out.println("birthday  =   " + birthday);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("birthday", birthday);
		mv.addObject("age", age);
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}

	//发生 TypeMismatchException的时候就　返回到index.jsp
	@ExceptionHandler(TypeMismatchException.class)
	public ModelAndView exceptionResolver(Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/index.jsp");
		return mv;
	}
}


















