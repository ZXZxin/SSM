package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SomeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("=============");
		// request.getRequestDispatcher("/welcome.jsp").forward(request, response);
		// 特例，加了斜杠访问不到
		// response.sendRedirect("/welcome.jsp");
		response.sendRedirect("welcome.jsp"); //特例
	}

}
