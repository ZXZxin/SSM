

### SimpleMappingExceptionResolver的简单使用(可以在发生异常时跳转到指定页面)


主要的`xml`配置

```xml
<bean class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
    <property name="defaultErrorView" value="/errors/error.jsp"/>
    <property name="exceptionAttribute" value="ex"/>
    <!--不同的异常跳转到不同的页面-->
    <property name="exceptionMappings">
        <props>
            <prop key="com.zxin.exceptions.NameException">/errors/nameError.jsp</prop>
            <prop key="com.zxin.exceptions.AgeException">/errors/ageError.jsp</prop>
        </props>
    </property>
</bean>
```