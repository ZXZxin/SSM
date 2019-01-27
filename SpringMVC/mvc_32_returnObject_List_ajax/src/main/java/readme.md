### 还是方法返回Object 之 List



后台代码: 

```java

@Controller    
@RequestMapping("/zxin")
public class MyController {

	@RequestMapping("/myAjax.do")
	@ResponseBody   // 将返回的数据放入到响应体中
	public Object doAjax()  {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("张三", 23));
		list.add(new Student("李四", 24));
		
		return list;
	}

}

```


前台代码:

```javascript
$(function() {
    $("button").click(function() {
        $.ajax({
            url:"zxin/myAjax.do",
            success:function(data){
                $(data).each(function(index){
                    alert(data[index].name + " " + data[index].age);
                });
            }
        });
    });
});
```