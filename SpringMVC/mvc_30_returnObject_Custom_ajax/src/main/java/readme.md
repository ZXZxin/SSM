### 还是返回Object 之 -- 这里是自定义的类型 Student

```java
@Controller    
@RequestMapping("/zxin")
public class MyController {

	@RequestMapping("/myAjax.do")
	@ResponseBody   // 将返回的数据放入到响应体中
	public Object doAjax()  {
//		return 123.234;
		return new Student("张三", 23);
	}

}

```

前台接收:

```javascript
$(function() {
    $("button").click(function() {
        $.ajax({
            url:"zxin/myAjax.do",
            success:function(data){
                alert(data.name + "  " + data.age);
//                        alert(data);
            }
        });
    });
});
```