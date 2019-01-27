### 使用自定义的ExceptionHandler来处理异常

```java
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("ex", ex);
		mv.setViewName("/errors/error.jsp");
		
		if(ex instanceof NameException) {
			// 执行一些操作
			mv.setViewName("/errors/nameError.jsp");
		}
		
		if(ex instanceof AgeException) {
			// 执行一些操作
			mv.setViewName("/errors/ageError.jsp");
		}
		
		return mv;
	}

}

```