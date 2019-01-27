

### 接收表单的参数(post)方式  以及  乱码问题解决


Controller方法中参数的种类: 

HttpServletRequest
HttpServletResponse
HttpSession
用于承载数据的 Model
请求中所携带的请求参数
对于前四种参数，在以后的学习过程中会逐个用到。
这里只举例讲解一下第五类参数： 
请求中所携带的请求参数。即处理器方法是如何接收请求参数的。



#### 表单接收参数

测试: 

* 启动项目


* 在表单中填入姓名和年龄，点击注册就到了http://localhost:9091/mvc_19_receiveParameters_Property/zxin/register.do


* 可以接收到参数


代码: 

```java
@Controller    
@RequestMapping("/zxin")    
public class MyController {

	@RequestMapping("/register.do")
	public ModelAndView doRegister(String name, int age) {

		System.out.println("name = " + name);
		System.out.println("age = " + age);

		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);
		mv.addObject("age", age);
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");

		return mv;
	}
}

```


#### 乱码问题解决

`web.xml`配置

```xml

<!-- 注册字符集过滤器 -->
<filter>
    <filter-name>CharacterEncodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>

    <!--指定字符集-->
    <init-param>
        <param-name>encoding</param-name>
        <param-value>utf-8</param-value>
    </init-param>
    <!--如果不设置下面的，则响应(response)的字符集不是我们指定的utf-8,可以看源码-->
    <init-param>
        <param-name>forceEncoding</param-name>
        <param-value>true</param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name>CharacterEncodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>


```

#### 关于forceEncoding的源码解读(重要)



* encoding：String 类型，指定字符集
* forceEncoding：boolean 类型，指定是否强制使用指定的字符集。若为 true，
    则代码中指定的字符集将不起作用。若为 false，则代码中若指定了字符集，
    就使用代码指定字符集；若代码中没有指定字符集，则使用这里指定的字符集。

```java
public class CharacterEncodingFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
    
        // 没有设置
        if (this.encoding != null && (this.forceEncoding || request.getCharacterEncoding() == null)) {
            request.setCharacterEncoding(this.encoding);
            if (this.forceEncoding) {
                response.setCharacterEncoding(this.encoding);
            }
        }
        filterChain.doFilter(request, response);
    }
}
```

以上源码的意思是，若使用 encoding 指定了字符集，
则一定使用该字符集的条件有两个：

* 要么 forceEncoding 为true；

* 要么代码中没有指定字符集。




一般代码都会加上`forceEncoding = true`
