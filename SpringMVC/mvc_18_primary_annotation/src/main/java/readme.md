

## 基本的mvc注解式开发程序



#### (1) 在xml中注册组件扫描器


```xml
<!-- 注册组件扫描器 -->
<context:component-scan base-package="com.zxin.handlers"/>
```


#### (2) @Controller（表示当前类是一个处理器） 、@RequestMapping（访问路径） 




测试下面代码:  (记得加上命名空间 /zxin)

* 必须带有zx参数: `http://localhost:9091/mvc_18_primary_annotation/zxin/second.do?name=zx`


```java
// 携带参数 params ,测试: 提交的请求中必须带有 name (且值是zx)参数，必须不能带有age参数
@RequestMapping(value="/second.do", params={"name=zx", "!age"})
public ModelAndView doSecond(HttpServletRequest request,
        HttpServletResponse response) {
    ModelAndView mv = new ModelAndView();
    mv.addObject("message", "执行doSecond()方法");
    mv.setViewName("/WEB-INF/jsp/welcome.jsp");
    return mv;
}
```
