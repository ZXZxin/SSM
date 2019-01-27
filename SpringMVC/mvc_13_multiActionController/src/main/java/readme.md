

### MultiActionController的第三种methodNameResolver : ParameterMethodNameResolver


测试方法:  (默认是action，可以指定)


* `http://localhost:9091/mvc_13_multiActionController/my.do?action=doFirst`

* `http://localhost:9091/mvc_13_multiActionController/my.do?action=doSecond`



`xml`配置: 


```xml
<bean class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping">
    <property name="urlMap">
        <map>
            <entry key="/my.do" value-ref="myController"/>
        </map>
    </property>
</bean>

<!-- 注册方法名称解析器 -->
<bean id="parameterMethodNameResolver" class="org.springframework.web.servlet.mvc.multiaction.ParameterMethodNameResolver">
    <!-- 若不指定paramName属性，则默认参数名称是action -->
    <!-- <property name="paramName" value="xxx"/> -->
</bean>

<!-- 注册处理器 -->
<bean id="myController" class="handlers.MyController">
    <property name="methodNameResolver" ref="parameterMethodNameResolver"/>
</bean>
```