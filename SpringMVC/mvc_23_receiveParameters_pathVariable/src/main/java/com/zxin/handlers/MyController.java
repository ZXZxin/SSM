package com.zxin.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller    
@RequestMapping("/zxin")
public class MyController {

	@RequestMapping("/{pname}/{age}/register.do")
	public ModelAndView doRegister(@PathVariable("pname") String name,@PathVariable int age) {
		System.out.println("name =  " + name);
		System.out.println("age =  " + age);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);
		mv.addObject("age", age);
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}
}


















