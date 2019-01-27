### 这个重定向(服务器外跳转)的项目很重要



#### 重定向，是两次请求(所以一般获取不到数据)


但是我们发现提交请求之后在地址栏可以看到数据: 


`http://localhost:9091/mvc_34_redirect_page_modelAndView/show.jsp?name=zxzxin&age=23`


放在后面也就是相当于: 

```java
mv.setViewName("redirect:/show.jsp?name=zxzxin&age=23");
```

所以在`show.jsp`中可以通过 `${param.name}`来获取携带的数据

```html
<body>

    show page<br>
    <!--
        param.myStudent 的底层执行的是 request.getParameter("myStudent"); // 所以可以获取到
        requestScope.myStudent 的底层执行的是 request.getAttribute("myStudent");
    -->
    ModelAndView携带的数据<br>
    ${param.pname}<br>
    ${param.page}<br>

    HttpSession携带的数据<br>

    ${sessionScope.myStudent}<br>

</body>
```


#### 重定向的路径问题在这里又不是特例了!!!

* 之前说过重定向在后台路径中不要加  `/`，但是在这里还是要加的(变成普通的)；

* 还有`WEB-INF`下不能重定向，所以将`show.jsp`放在`web-root`下；

* 通过`ModelAndView`和`HttpSession`携带数据都可以的;

* 注意Http协议中不能放对象，只能放变量(我一开始写了mv.addObject("myStudent", student))显然不能获取

后台代码：
```java
@Controller
public class MyController{

    @RequestMapping("/zxin/register.do")
    public ModelAndView doRegister(Student student, HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.addObject("pname", student.getName());
        mv.addObject("page", student.getAge());
        session.setAttribute("myStudent", student);
        //这里和之前的重定向的特例不同，这里要加上 /
        //还有， WEB-INF下，不能重定向，所以这里移到了/ (WEB-ROOT)下
        mv.setViewName("redirect:/show.jsp");
        return mv;
    }
}
```


#### 演示结果

```c
show page
ModelAndView携带的数据
zxzxin
23
HttpSession携带的数据
Student [name=zxzxin, age=23]
```
