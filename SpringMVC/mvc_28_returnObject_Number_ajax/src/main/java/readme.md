


### Controller中的方法返回 Object 之 返回 - Number


#### 需要添加的新的jar包

```xml
   <!--需要添加的新的jar包-->

<!--jackson相关的包(把Object转换成JSON对象)-->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-core</artifactId>
    <version>2.9.6</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-annotations</artifactId>
    <version>2.9.6</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.9.6</version>
</dependency>

```

#### 重点
上面这些Jar包，只需要添加，而不需要手动写代码，只需要**注册MVC注解驱动**即可自动加载这些

```xml
<!-- 注册MVC注解驱动 -->
<mvc:annotation-driven/>
```


然后Controller代码

**这里也要注意 : 这里是真的需要使用`@ResponseBody`注解，因为这里的返回值不是void**

如果不加`@ResonseBody`注解的话，返回字符串会被当做路径跳转，所以如果要想返回字符串信息，必须加上`@ResponseBody`
```java
@Controller    
@RequestMapping("/zxin")
public class MyController {

	@RequestMapping("/myAjax.do")
	@ResponseBody   // 这个是必须的，因为有返回值， 放到响应体，而不是看做视图: 将返回的数据放入到响应体中
	public Object doAjax()  {
		return 123.456;  // 返回number
	}
}
```

前台代码也有一些不同: 

```javascript
$(function () {
    $("#myButton").click(function () {
        $.ajax({
            url: "${pageContext.request.contextPath}/zxin/myAjax.do",
            success: function (data) {
               alert(data) // 这个是和上个项目不同的地方, 直接得到返回的值
            },
            dataType: "json"
        })
    })
})
```