


### Controller的方法返回Object 之返回 String (注意乱码问题,使用produce解决)


#### 注意注意 !!　这个项目还没有写成功


问题: 尝试了将"china中国"改成123.123就可以正确在success的function中接收到

但是字符串就硬是不行。


#### 这个项目主要是讲如果返回字符串有中文乱码怎么处理，处理就是加上`produces = “text/html;charset=utf-8”`

代码：


```java
@Controller    
@RequestMapping("/zxin")
public class MyController {

	// 乱码问题解决深入: https://blog.csdn.net/qq_32361173/article/details/79364866
	@RequestMapping(value = "/myAjax.do", produces = "text/html;charset=utf-8") // 配置后面这个是为了防止乱码
	@ResponseBody   //  将返回的数据放入到响应体中
	public String doAjax()  {
//	public Object doAjax()  {
//		return 123.123; // 可以正常返回
		return "china中国"; // 返回不了，不知道为什么
	}
}

```