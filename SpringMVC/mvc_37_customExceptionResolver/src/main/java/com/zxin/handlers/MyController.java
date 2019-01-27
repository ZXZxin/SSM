package com.zxin.handlers;

import com.zxin.exceptions.AgeException;
import com.zxin.exceptions.NameException;
import com.zxin.exceptions.StudentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller    
@RequestMapping("/zxin")
public class MyController {

	@RequestMapping("/register.do")
	public ModelAndView doRegister(String name, int age) throws StudentException {

		// int i = 3 / 0;
		
		if(!"zxzxin".equals(name)) {
			throw new NameException("用户名不正确");
		}
		
		if(age > 60) {
			throw new AgeException("太老了");
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);
		mv.addObject("age", age);
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}
	

}


















