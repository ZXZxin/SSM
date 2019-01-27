

### 使用Ajax提交请求(重点)(在 *.do和/   (web.xml配置)中踩大坑!!!!!!!)



测试: 点击index.jsp的按钮即可


pom.xml需要添加gson的包: 


```xml
<!--新添加的Json jar包-->
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.4</version>
</dependency>
```


前台部分代码：

```javascript
$(function () {
    $("#myButton").click(function () {
        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/zxin/myAjax.do",
            data: {
                name:"zhengxin",
                age:19
            },
            success: function (data) {
                var json = eval(data);
                alert(json.pname + "  "  + json.page);
            },
            dataType: "json"
        })
    })
})
```

后台使用Gson来接收数据(没有使用Json)

```java
@Controller    
@RequestMapping("/zxin")
public class MyController {

	@RequestMapping("/myAjax.do")
	//	@ResponseBody // 将返回的数据放入到响应体中，这样才能接收到 Ajax的数据 但是这里不需要，因为我不是返回String，而是void
	// 有关博客: https://www.cnblogs.com/yanghaolie/p/9681148.html  & https://www.cnblogs.com/NieXiaoHui/p/5053997.html
	public void doAjax(String name, int age, HttpServletResponse response)throws IOException{

		System.out.println("this it controller! ");

		HashMap<String,Object> map = new HashMap<>();

		map.put("pname", name);
		map.put("page", age);

		Gson gson = new Gson();
		response.getWriter().print(gson.toJson(map)); // 写到响应
	}
}
```



#### 重点

这里一定要将 DispatherServlet的配置中　　/ 改成 *.do, 不然会访问不到Controller


虽然下面两个博客说要加上@ResponseBody，但是改了好久发现是上面的问题


也就是说下面这行代码, 但是问题却不是出在这里，因为我的controller的方法的返回值是void,而不是String(不看做是视图，而是数据)

```java
//	@ResponseBody // 将返回的数据放入到响应体中，这样才能接收到 Ajax的数据 但是这里不需要，因为我不是返回String，而是void
```

博客

* `https://www.cnblogs.com/NieXiaoHui/p/5053997.html`
* `https://www.cnblogs.com/yanghaolie/p/9681148.html`

```xml

<servlet>
    <servlet-name>springMVC</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:springmvc.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
    <servlet-name>springMVC</servlet-name>
    <!--这个项目比较特殊， 这里必须要使用*.do -->
    <!--<url-pattern>/</url-pattern>-->
    <url-pattern>*.do</url-pattern>   <!--必须改-->
</servlet-mapping>
```