


### AbstractController的使用(继承WebContentGenerator，实现Controller)(可以设置 Http的提交方式 )


配置

```xml
<!-- 注册处理器 -->
	<bean id="/my.do" class="handlers.MyController">
		<property name="supportedMethods" value="POST"/>
	</bean>
```

上面的配置指定只能使用表单提交: 于是jsp如下编写
```html
<form action="${pageContext.request.contextPath }/my.do" method="post">
    <input type="submit" value="submit" />
</form>
```

```java
public class MyController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "Hello SpringMVC World!");
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}
}

```



#### 源码: 使用了模板方法设计模式


```java
@Override
public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
        throws Exception {

    // Delegate to WebContentGenerator for checking and preparing.
    checkRequest(request);
    prepareResponse(response);

    // Execute handleRequestInternal in synchronized block if required.
    if (this.synchronizeOnSession) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Object mutex = WebUtils.getSessionMutex(session);
            synchronized (mutex) {
                return handleRequestInternal(request, response);
            }
        }
    }

    return handleRequestInternal(request, response);
}

/**
 * Template method. Subclasses must implement this.
 * The contract is the same as for {@code handleRequest}.
 * @see #handleRequest
 */
protected abstract ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
        throws Exception;

```