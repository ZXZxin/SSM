package com.zxin.handlers;


import com.zxin.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController{

    @RequestMapping("/zxin/register.do")
    public ModelAndView doRegister(Student student){
        ModelAndView mv = new ModelAndView();
        mv.addObject("myStudent", student);
        mv.setViewName("forward:/WEB-INF/jsp/show.jsp"); // 不加forward默认就是 forward
        return mv;
    }
}
