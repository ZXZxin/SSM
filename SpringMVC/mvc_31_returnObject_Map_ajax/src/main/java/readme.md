

### 还是方法返回Object 之 Map

后台: 


```java
@Controller    
@RequestMapping("/zxin")
public class MyController {

	@RequestMapping("/myAjax.do")
	@ResponseBody   // 将返回的数据放入到响应体中
	public Object doAjax()  {
		Map<String, Student> map = new HashMap<String, Student>();
		map.put("stu1", new Student("张三", 23) );
		map.put("stu2", new Student("李四", 24) );
		return map;
	}

}
```

前台: 
```javascript
$(function() {
    $("button").click(function() {
        $.ajax({
            url:"zxin/myAjax.do",
            success:function(data){
                alert(data.stu1.name + "  " + data.stu2.age);
            }
        });
    });
});
```