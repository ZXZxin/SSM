

### SpringMVC基础程序　03 (关于如果web.xml中一定要使用 / (在restful中要使用), 而是不是*.do的解决方案)

```xml
<servlet-mapping>
    <servlet-name>springMVC</servlet-name>
    <!--<url-pattern>*.do</url-pattern>-->

    <!--配成/是为了符合 rest风格，但是会拦截一些静态资源，有三种解决方式 即项目mvc_03_urlpattern-->
    <!--  这里如果配置　/ 就需要用三种解决办法，才能加载静态资源-->
    <url-pattern>/</url-pattern>
  </servlet-mapping>
```

(1)方案一 : 在web.xml中配置 <servlet-mapping>default</servlet-mapping>

(2)方案二 : 在springmvc.xml中配置 `<mvc:default-servlet-handler>`

(3)方案三 : 在springmvc.xml中配置 `<mvc:recources/>`

```xml

<!--方案一  和Tomcat自带的web.xml有关 -->

  <servlet-mapping>
    <servlet-name>default</servlet-name>
    <url-pattern>*.jpg</url-pattern>
  </servlet-mapping>
  <servlet-mapping>
    <servlet-name>default</servlet-name>
    <url-pattern>*.png</url-pattern>
  </servlet-mapping>
  <servlet-mapping>
    <servlet-name>default</servlet-name>
    <url-pattern>*.css</url-pattern>
  </servlet-mapping>
  <servlet-mapping>
    <servlet-name>default</servlet-name>
    <url-pattern>*.js</url-pattern>
  </servlet-mapping>
```


```xml

<!--方案二-->
<mvc:default-servlet-handler/>

<!--方案三-->
<mvc:resources location="/images/" mapping="/images/**"/>

```

