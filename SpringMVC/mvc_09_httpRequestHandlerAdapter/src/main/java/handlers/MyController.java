package handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

public class MyController implements HttpRequestHandler {

	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message", "Hello SpringMVC World!");
		request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(request, response);
	}

}
