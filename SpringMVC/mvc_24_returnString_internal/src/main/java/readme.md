

### 关于返回值不是ModelAndView ,而是String


测试输入:`http://localhost:9091/mvc_24_returnString_internal/zxin/some.do` 


* ModelAndView: 既带有数据，又有视图(转向)

* String: 只有视图，没有数据(模型)


```java
@Controller    // 表示当前类是一个处理器
@RequestMapping("/test")     // 命名空间
public class MyController {

	@RequestMapping("/some.do")
	public String doSome() {
		return "/WEB-INF/jsp/welcome.jsp";  // 物理视图 
	}
}

```