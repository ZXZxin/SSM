### 数据回显的解决(重要)


##### 上一个项目虽然处理了TypeMismatchException的问题，但是不知道是那个item出错了


后台代码: 


* 使用异常处理 `@ExceptionHandler`；

* 使用`request.getParameter`实现数据回显；

* 使用`String errorMSG = ex.getMessage();`获取异常；

```java
@Controller    
@RequestMapping("/zxin")    
public class MyController {
    //数据回显示(使用request.getParameter)　以及　显示哪一项出错（getMessage中判断(contains)）
    @ExceptionHandler(TypeMismatchException.class)
    public ModelAndView exceptionResolver(HttpServletRequest request, Exception ex) {
        ModelAndView mv = new ModelAndView();
        
        String age = request.getParameter("age");
        String birthday = request.getParameter("birthday");
        
        // 捕获到的异常信息
        String errorMSG = ex.getMessage();
        if(errorMSG.contains(age)) {
            mv.addObject("ageErrors", "年龄输入有误");
        }
        if(errorMSG.contains(birthday)) {
            mv.addObject("birthErrors", "日期输入有误");
        }
        
        mv.addObject("age", age);
        mv.addObject("birthday", birthday);
        mv.addObject("ex", ex);
        mv.setViewName("/index.jsp");
        return mv;
    }
}
```

前台代码: 
```html
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
  	${ex.message}  <!--可以显示出错信息-->
  	<br>
    <form action="${pageContext.request.contextPath }/zxin/register.do" method="POST">
    	年龄：<input type="text" name="age" value="${age }"/>${ageErrors }<br>
    	生日：<input type="text" name="birthday" value="${birthday }"/>${birthErrors }<br>
    	<input type="submit" value="注册"/>
    </form>
  </body>
</html>

```