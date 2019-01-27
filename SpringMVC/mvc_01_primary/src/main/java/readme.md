
### SpringMVC的基本程序


(1)相比Spring，需要添加下面的依赖

```xml
<!--添加的jar包-->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>4.2.4.RELEASE</version>
</dependency>
```

(2)这里如果如果没有配置 springMVC配置文件的属性(位置和名字)，

   就必须将名称起成 -servlet.xml，且放在/web-inf下，不然会报错
   
```xml
 <servlet>
    <servlet-name>zxin</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>zxin</servlet-name>
    <url-pattern>*.do</url-pattern>
  </servlet-mapping>
```

Controller简单配置: 

```java
public class MyController implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Hello SpringMVC !");
        mv.setViewName("/WEB-INF/welcome.jsp"); // view路径
        return mv;
    }
}
```