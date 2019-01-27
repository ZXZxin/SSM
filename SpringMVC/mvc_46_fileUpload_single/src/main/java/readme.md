
### 单个文件上传的实现


##### 需要添加的jar包

```xml
  <!--文件上传相关jar包,io是所依赖的jar包-->
<dependency>
    <groupId>commons-fileupload</groupId>
    <artifactId>commons-fileupload</artifactId>
    <version>1.3.3</version>
</dependency>
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.6</version>
</dependency>
```

主要的代码: 
```java

@Controller    
@RequestMapping("/zxin")
public class MyController {

	@RequestMapping("/upload.do")
	public String doFileUpload(MultipartFile img, HttpSession session) throws Exception {
		
		// String path = "d:/images";
		String path = session.getServletContext().getRealPath("/images");
		if (img.getSize() > 0) { // 当没有选择文件的时候还是直接返回success.jsp
			// 获取到上传文件的原始名称
			String fileName = img.getOriginalFilename();
			if (fileName.endsWith("jpg") || fileName.endsWith("png")) { // 限制上传的类型
				File file = new File(path, fileName);
				img.transferTo(file);
			}
		}
		return "/success.jsp";
	}

}

```
前台注意表单需要加 `enctype="multipart/form-data"`属性

```html
<body>
    <form action="${pageContext.request.contextPath }/zxin/upload.do" method="POST" enctype="multipart/form-data">
    	文件：<input type="file" name="img"/><br>
    	<input type="submit" value="上传"/>
    </form>
  </body>
```


##### 需要注意的问题

```xml
<!--注意这里的id 一定要是这个名字 不能随便取-->
<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
    <property name="defaultEncoding" value="utf-8"/> <!--解决乱码问题-->
    <property name="maxUploadSize" value="1048576"/> <!--最大文件上传大小 不能超过1MB-->
</bean>
```

因为查看源码知道在`DispatcherServlet`中定义了这个字符串(id)

```java
public class DispatcherServlet extends FrameworkServlet {

	/** Well-known name for the MultipartResolver object in the bean factory for this namespace. */
	public static final String MULTIPART_RESOLVER_BEAN_NAME = "multipartResolver";
}
```

下面调用了`getBean`: 

```java
public class DispatcherServlet extends FrameworkServlet {
    private void initMultipartResolver(ApplicationContext context) {
        try {
            //这里调用了
            this.multipartResolver = context.getBean(MULTIPART_RESOLVER_BEAN_NAME, MultipartResolver.class);
            if (logger.isDebugEnabled()) {
                logger.debug("Using MultipartResolver [" + this.multipartResolver + "]");
            }
        }
        catch (NoSuchBeanDefinitionException ex) {
            // Default is no multipart resolver.
            this.multipartResolver = null;
            if (logger.isDebugEnabled()) {
                logger.debug("Unable to locate MultipartResolver with name '" + MULTIPART_RESOLVER_BEAN_NAME +
                        "': no multipart request handling provided");
            }
        }
    }
}
```

#### 为什么要注册mvc注解驱动呢 `<mvc:annotation-driven/>`

因为`MultipartFile`只是一个接口，而没有实现类，在注册注解驱动之后，mvc会帮我们创建实现类。

#### 注意: 文件上传一般是上传到 web应用的根下，而不是c盘，d盘...，所以我们用HttpSession获取应用的根

所以`String path = session.getServletContext().getRealPath("/images");`