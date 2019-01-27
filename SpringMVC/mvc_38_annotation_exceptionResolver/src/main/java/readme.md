### 关于使用注解解决异常的方式


一个注解`@ExceptionHandler`

这里使用一个`BaseController`来简化代码(有可能有多个Controller需要处理异常)


```java
@Controller    
public class BaseController {

	// 处理NameException异常
	@ExceptionHandler(NameException.class)
	public ModelAndView handlerNameException(Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("ex", ex);
		// 执行一些操作
		mv.setViewName("/errors/nameError.jsp");
		return mv;
	}
	
	// 处理AgeException异常
	@ExceptionHandler(AgeException.class)
	public ModelAndView handlerAgeException(Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("ex", ex);
		// 执行一些操作
		mv.setViewName("/errors/ageError.jsp");
		return mv;
	}
	
	// 处理其它异常
	@ExceptionHandler
	public ModelAndView handlerException(Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("ex", ex);
		mv.setViewName("/errors/error.jsp");
		return mv;
	}
}
```