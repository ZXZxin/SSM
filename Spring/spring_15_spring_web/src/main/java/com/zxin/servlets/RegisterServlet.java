package com.zxin.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zxin.beans.Student;
import com.zxin.service.IStudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");
		Integer age = Integer.valueOf(ageStr);
		
		Student student = new Student(name, age);
		
		// 获取到Spring容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		System.out.println("ac = " + ac); // 这个每次刷新一次页面(post请求)，就会创建一个容器对象
		
		// 从Spring容器中获取到Service对象
		IStudentService service = (IStudentService) ac.getBean("studentService");
		
		// 调用Service的addStudent()完成插入
		service.addStudent(student);
		
		request.getRequestDispatcher("/welcome.jsp").forward(request, response);
		
	}

}
