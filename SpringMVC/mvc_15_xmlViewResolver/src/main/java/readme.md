


### 第三种视图解析器 : XMLViewResolver (将视图单独作为一个xml文件)


测试输入: `http://localhost:9091/mvc_16_ResourcesBundleViewResolver/my.do`

可以访问单个配置文件臃肿。


```xml

<!-- 注册视图解析器 -->
<bean class="org.springframework.web.servlet.view.XmlViewResolver">
    <property name="location" value="classpath:myViews.xml"/>
</bean>

<!-- 注册处理器 -->
<bean id="/my.do" class="handlers.MyController"/>
```