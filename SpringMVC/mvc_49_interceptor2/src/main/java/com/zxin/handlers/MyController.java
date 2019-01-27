package com.zxin.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller    
@RequestMapping("/zxin")
public class MyController {

	@RequestMapping("/some.do")
	public String doSome() {
		
		System.out.println("执行处理器的doSome()方法");
		
		return "/WEB-INF/jsp/welcome.jsp";
	}

}


















