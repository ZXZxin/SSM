

### 多个文件的上传


后台代码: 
```java

@Controller    
@RequestMapping("/zxin")    
public class MyController {

	@RequestMapping("/upload.do")
	public String doFileUpload(@RequestParam MultipartFile[] imgs, HttpSession session) throws Exception {
		
		String path = session.getServletContext().getRealPath("/images");
		for(MultipartFile img : imgs) {
			if (img.getSize() > 0) {
				// 获取到上传文件的原始名称
				String fileName = img.getOriginalFilename();
				if (fileName.endsWith("jpg") || fileName.endsWith("png") || fileName.endsWith("gif")){
					File file = new File(path, fileName);
					img.transferTo(file);
				}
			}
		}
		return "/success.jsp";
	}

}
```
**需要注意的是一定要加上@RequestParam注解，因为格式需要转换**


前台代码: 
```html
<body>
<form action="${pageContext.request.contextPath }/zxin/upload.do" method="POST" enctype="multipart/form-data">
    文件1：<input type="file" name="imgs"/><br>
    文件2：<input type="file" name="imgs"/><br>
    文件3：<input type="file" name="imgs"/><br>
    <input type="submit" value="上传"/>
</form>
</body>
```


### 源码相关

`DispatcherServlet`中的`doDispatch`方法中: 


* DisPatcherServlet接收到请求之后，会判断是不是multipartRequest请求，如果是，会进行文件的处理；


```java
boolean multipartRequestParsed = false;

...

processedRequest = checkMultipart(request);
multipartRequestParsed = (processedRequest != request);
```

其中`checkMultipart`方法就是检查这个请求是不是multipart请求。