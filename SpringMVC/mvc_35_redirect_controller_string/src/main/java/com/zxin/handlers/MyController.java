package com.zxin.handlers;

import com.zxin.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller    
@RequestMapping("/zxin")
public class MyController {

	// 当前访问路径: http://127.0.0.1:9091/mvc_35_redirect_controller_string/zxin
	// 当前访问资源: /register.do
	@RequestMapping("/register.do")
	public String doRegister(Student student, Model model) {

		// 注意不能直接 model.addAttribute("myStudent", student);
		model.addAttribute("pname", student.getName());
		model.addAttribute("page", student.getAge());
		
		// 如果是带上/ 则路径变成: http://127.0.0.1:9091/mvc_35_redirect_controller_string/other.do
		// return "redirect:/other.do";  //这里不能带斜杠，因为有一个 /zxin (requestMapping)
		
		// 正确的路径: 不带斜杠(变成相对路径 )http://127.0.0.1:9091/mvc_35_redirect_controller_string/zxin/other.do
		return "redirect:other.do";
	}
	
	// 应该的访问路径: http://127.0.0.1:9091/mvc_35_redirect_controller_string/zxin/other.do
	@RequestMapping("/other.do")
	public String doOther(String pname, int page) {
		System.out.println("pname = " + pname);
		System.out.println("page = " + page);
		return "/show.jsp";
	}
}


















