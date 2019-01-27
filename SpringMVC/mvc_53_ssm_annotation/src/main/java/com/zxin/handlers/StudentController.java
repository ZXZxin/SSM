package com.zxin.handlers;


import com.zxin.beans.Student;
import com.zxin.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/zxin")
public class StudentController {

    // 将IStudentService 注入到Controller
    @Autowired
    @Qualifier("studentService")
//    @Resource(name = "studentService")
    private IStudentService service;

    // 为了构造注入
    public void setService(IStudentService service) {
        this.service = service;
    }

    @RequestMapping("/register.do")
    public String handleRequest(String name, int age) throws Exception {
        Student student = new Student(name, age);
        service.addStudent(student);
        return "/welcome.jsp";
    }
}
