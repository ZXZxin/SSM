package com.zxin.handlers;


import com.zxin.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class MyController{

    @RequestMapping("/zxin/register.do")
    public ModelAndView doRegister(Student student, HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.addObject("pname", student.getName());
        mv.addObject("page", student.getAge());
        session.setAttribute("myStudent", student);
        //这里和之前的重定向的特例不同，这里要加上 /
        //还有， WEB-INF下，不能重定向，所以这里移到了/ (WEB-ROOT)下
        mv.setViewName("redirect:/show.jsp");
        return mv;
    }
}
