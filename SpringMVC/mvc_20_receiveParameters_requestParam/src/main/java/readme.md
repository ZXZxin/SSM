

### 校正参数RequestParam


```java
@Controller    
@RequestMapping("/zxin")    
public class MyController {

	// 使用RequestParam 来修正参数
	@RequestMapping("/register.do")
	public ModelAndView doRegister(@RequestParam("pname") String name, int age) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);
		mv.addObject("age", age);
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}
}

```

```html
<form action="${pageContext.request.contextPath }/zxin/register.do" method="POST">
    姓名：<input type="text" name="pname"/><br> <!--这里就是需要校正的参数 pname -->
    年龄：<input type="text" name="age"/><br>
    <input type="submit" value="注册"/>
</form>
```