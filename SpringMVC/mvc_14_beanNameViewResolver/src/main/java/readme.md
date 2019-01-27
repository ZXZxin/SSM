
### 视图解析器

#### 不使用默认的视图解析器InternalResourceViewResolver,而是BeanNameViewResolver


* 这个视图解析器既可以访问内部的资源，又可以访问外部的资源(淘宝、京东)

```xml
 <!--注册视图解析器: 不能使用默认的视图解析器InternalResourceViewResolver ，要使用下面的-->
    <bean class="org.springframework.web.servlet.view.BeanNameViewResolver"></bean>

    <!--下面定义三个视图 (一个内部视图(JstlView)，两个外部视图()-->

    <!--内部资源-->
    <bean id="internalResource" class="org.springframework.web.servlet.view.JstlView">
        <property name="url" value="/WEB-INF/jsp/welcome.jsp"/>
    </bean>

    <!--外部资源-->
    <bean id="taobao" class="org.springframework.web.servlet.view.RedirectView">
        <property name="url" value="https://www.taobao.com"/>
    </bean>
    <bean id="jd" class="org.springframework.web.servlet.view.RedirectView">
        <property name="url" value="https://www.jd.com"/>
    </bean>

    <!--注册处理器-->
    <bean id="/my.do" class="handlers.MyController"/>
```


注意:


```xml
<!--这里必须要导入这个jstl的jar包，不然访问内部资源的时候会报错-->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
    <version>1.2</version>
</dependency>
```