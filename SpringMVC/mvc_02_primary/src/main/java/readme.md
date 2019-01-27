

### SpringMVC基础程序02


* 这里配置了springMVC文件的位置以及名称

* 配置了当Tomcat一启动就会创建DispatcherServlet使得加载速度更快

* 在springmvc.xml中配置了　前后缀视图解析器


```xml
 <!--注册中央调度器-->
  <servlet>
    <!--如果不在下面配置init-param, 则springMVC配置文件名字必须是zxin-serlvet.xml-->
    <servlet-name>springMVC</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <!--指定SpringMVC配置文件的位置以及文件名-->
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:springmvc.xml</param-value>
    </init-param>
    <!--在Tomcat启动时直接创建当前Servlet-->
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>springMVC</servlet-name>
    <url-pattern>*.do</url-pattern>
  </servlet-mapping>
```

视图解析器:

```xml
<!-- 注册视图解析器 -->
<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name="prefix" value="/WEB-INF/jsp/"/>
    <property name="suffix" value=".jsp"/>
</bean>
```

SpringMVC执行流程:


下面这个文件，有默认的配置 (包括处理器映射器、处理器适配器、视图解析器等)
`org/springframework/spring-webmvc/4.2.4.RELEASE/spring-webmvc-4.2.4.RELEASE.jar!/org/springframework/web/servlet/DispatcherServlet.properties`