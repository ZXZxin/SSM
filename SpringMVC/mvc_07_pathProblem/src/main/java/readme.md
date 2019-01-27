

### 关于路径问题(后台路径(带斜杠))的一个特例: 重定向




```java
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

```