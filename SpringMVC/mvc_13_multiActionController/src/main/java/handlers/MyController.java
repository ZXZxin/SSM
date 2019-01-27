package handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MyController extends MultiActionController {

	public ModelAndView doFirst(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "执行doFirst()方法");
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}
	
	public ModelAndView doSecond(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "执行doSecond()方法");
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}
	
	public ModelAndView doThird(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("/WEB-INF/jsp/welcome.jsp");
	}

}
