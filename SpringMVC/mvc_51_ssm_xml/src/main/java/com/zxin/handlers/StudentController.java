package com.zxin.handlers;


import com.zxin.beans.Student;
import com.zxin.services.IStudentService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentController implements Controller {

    // 将IStudentService 注入到Controller
    private IStudentService service;


    // 为了构造注入
    public void setService(IStudentService service) {
        this.service = service;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        Integer age = Integer.valueOf(ageStr);
        Student student = new Student(name, age);
        service.addStudent(student);
        return new ModelAndView("/welcome.jsp");
    }
}
