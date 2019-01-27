package com.zxin.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller    
@RequestMapping("/zxin")
public class MyController {

	// 使用RequestParam 来修正参数
	@RequestMapping("/register.do")
	public ModelAndView doRegister(@RequestParam("pname") String name, int age) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);
		mv.addObject("age", age);
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}
}


















