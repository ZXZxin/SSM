## 和上面一个项目相比就加了一个视图解析器


测试:

输入 `http://localhost:9091/mvc_25_returnString_internal_2/zxin/some.do`

* 物理视图

* 逻辑视图


```xml
<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name="prefix" value="/WEB-INF/jsp/"/>
    <property name="suffix" value=".jsp"/>
</bean>
```