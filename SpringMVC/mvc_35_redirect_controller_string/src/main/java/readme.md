

### 重定向到其他Controller & 返回String & Model携带数据


* 注意redirect的路径问题, 这里不能看做带斜杠的后台路径，而是应该看成相对路径(因为requestMapping)


```java
@Controller    
@RequestMapping("/zxin")
public class MyController {

	// 当前访问路径: http://127.0.0.1:9091/mvc_35_redirect_controller_string/zxin
	// 当前访问资源: /register.do
	@RequestMapping("/register.do")
	public String doRegister(Student student, Model model) {

		// 注意不能直接 model.addAttribute("myStudent", student);
		model.addAttribute("pname", student.getName());
		model.addAttribute("page", student.getAge());
		
		// 如果是带上/ 则路径变成: http://127.0.0.1:9091/mvc_35_redirect_controller_string/other.do
		// return "redirect:/other.do";  //这里不能带斜杠，因为有一个 /zxin (requestMapping)
		
		// 正确的路径: 不带斜杠(变成相对路径 )http://127.0.0.1:9091/mvc_35_redirect_controller_string/zxin/other.do
		return "redirect:other.do";
	}
	
	// 应该的访问路径: http://127.0.0.1:9091/mvc_35_redirect_controller_string/zxin/other.do
	@RequestMapping("/other.do")
	public String doOther(String pname, int page) {
		System.out.println("pname = " + pname);
		System.out.println("page = " + page);
		return "/show.jsp";
	}
}
```