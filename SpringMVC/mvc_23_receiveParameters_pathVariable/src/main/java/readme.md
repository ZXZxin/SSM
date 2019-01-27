


### 关于直接在浏览器输入地址来访问Controller的方式



测试输入: 


* `http://localhost:9091/mvc_23_receiveParameters_pathVariable/zxin/zhengxin/19/register.do`


上述输入后，浏览器显示: 

```c
name = zhengxin
age = 19
```


代码: 

```java
@Controller    
@RequestMapping("/zxin")
public class MyController {

	@RequestMapping("/{pname}/{age}/register.do")
	public ModelAndView doRegister(@PathVariable("pname") String name,@PathVariable int age) {
		System.out.println("name =  " + name);
		System.out.println("age =  " + age);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);
		mv.addObject("age", age);
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}
}
```