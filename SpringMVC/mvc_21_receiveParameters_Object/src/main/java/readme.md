## 关于使用对象 Student作为接收参数时的使用

```java
@Controller    
@RequestMapping("/test")    
public class MyController {

	@RequestMapping("/register.do")
	public ModelAndView doRegister(Student student) {
		System.out.println("name = " + student.getName());
		System.out.println("age = " + student.getAge());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("student", student);
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}
}

```

```html
<form action="${pageContext.request.contextPath }/test/register.do" method="POST">
    <!-- 整体接收时，要求表单参数名与对象属性名相同 -->
    姓名：<input type="text" name="name"/><br>
    年龄：<input type="text" name="age"/><br>
    <input type="submit" value="注册"/>
</form>
```