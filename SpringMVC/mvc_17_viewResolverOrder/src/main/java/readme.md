

### 当定义了多个视图解析器的时候，会优先使用哪个呢? 


* 如果没有指定里面的一个属性(`order`)，就是从上到下优先级降低(上面的高)


* 如果指定了里面的属性`order`,就是数字越小的(必须大于0)，优先级越高


* 一般有多个视图解析器的话，在最后加上一个默认的视图解析器(InternalResourceViewResolver);


```xml

<!-- 注册视图解析器1 -->
<bean class="org.springframework.web.servlet.view.ResourceBundleViewResolver">
    <property name="basename" value="myViews"/>
    <property name="order" value="3"/>
</bean>

<!-- 注册视图解析器2 -->
<bean class="org.springframework.web.servlet.view.XmlViewResolver">
    <property name="location" value="classpath:myViews.xml"/>
    <property name="order" value="1"/>
</bean>

<!-- 注册视图解析器3 : 如果有多个视图解析器，最后加上一个默认的(相当于你自己定义了，就没有默认的了) -->
<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver"/>

```