package com.zxin.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller                   // 表示当前类是一个处理器
@RequestMapping("/zxin")      // 命名空间
public class MyController {

	// method 指定必须提交的方式 (加上post让代码更加的安全 (不能通过输入地址访问))
	@RequestMapping(value={"/my.do", "hello.do"}/*, method=RequestMethod.POST*/)
	public ModelAndView doFirst(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "执行doFirst()方法");
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}

	// 携带参数 params ,测试: 提交的请求中必须带有 name (且值是zx)参数，必须不能带有age参数
	@RequestMapping(value="/second.do", params={"name=zx", "!age"})
	public ModelAndView doSecond(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "执行doSecond()方法");
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}


	/*---------------------------通配符的一些-----------------------------*/

	// 资源名称必须以third开头
	@RequestMapping("/third*.do")
	public ModelAndView doThird(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "执行doThird()方法");
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}

	// 资源名称必须以fourth结尾
	@RequestMapping("/*fourth.do")
	public ModelAndView doFourth(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "执行doFourth()方法");
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}

	// 路径级数的绝对匹配，即要求在test与fifth.do之间必须要有一级路径
	@RequestMapping("/*/fifth.do")
	public ModelAndView doFifth(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "执行doFifth()方法");
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}

	// 要求在test与sixth.do之间可以包含多级路径，也可以没有其它路径
	@RequestMapping("/**/sixth.do")
	public ModelAndView doSixth(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "执行doSixth()方法");
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}
}


















