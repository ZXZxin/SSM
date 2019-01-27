package com.zxin.handlers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller    
@RequestMapping("/zxin")
public class MyController {

	@RequestMapping("/system.do")
	public String doSystem(HttpSession session) {
		
		System.out.println("执行处理器的doSome()方法");
		
		return "/welcome.jsp";
	}

}


















