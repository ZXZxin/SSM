### 处理器适配器 HandlerAdapter

* Controller : SimpleControllerHandlerAdapter

所有实现了 Controller 接口的处理器Bean，均是通过此适配器进行适配、执行的。
Controller 接口中有一个方法： handlerRequest

* HttpRequestHandler: HttpRequestHandlerAdapter (这个项目就是演示的这个)

所有实现了 HttpRequestHandler 接口的处理器 Bean，均是通过此适配器进行适配、执行的。
HttpRequestHandler 接口中有一个方法：handlerRequest

当然，此时视图解析器也无需再配置前辍与后辍了。即在 springmvc.xml 中无需声明视图解析器的Bean 了。


代码: 
```java
public class MyController implements HttpRequestHandler {

	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message", "Hello SpringMVC World!");
		request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(request, response);
	}

}

```


适配器模式解决的问题是，使得原本由于接口不兼容而不能一起工作的那些类可以在一起工作。所以处理器适配器所起的作用是，将多种处理器（实现了不同接口的处理器），通过处理器适配器的适配，使它们可以进行统一标准的工作，对请求进行统一方式的处理。
只所以要将 Handler 定义为 Controller 接口的实现类，就是因为这里使用的处理器适配器是 SimpleControllerHandlerAdapter。打开其源码，可以看到将 handler 强转为了 Controller。在定义 Handler 时，若不将其定义为 Controller 接口的实现类，这里的强转要出错的。
当然，中央调度器首先会调用该适配器的 supports()方法，判断该 Handler 是否与
Controller 具有 is-a 关系。在具有 is-a 关系的前提下，才会强转。

