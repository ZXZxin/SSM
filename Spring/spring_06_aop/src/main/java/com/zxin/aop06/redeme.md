


多个通知同时植入到目标对象中


```xml
<!-- 生成多个代理对象 : 前置和后置 -->
<bean id="serviceProxy" class="org.springframework.aop.framework.ProxyFactoryBean">
    <property name="target" ref="someService"/>
    <property name="interceptorNames" value="myBeforeAdvice,myAfterAdvice"/> <!--比下面的方法更加简单的写法-->
    <!-- <property name="interceptorNames">
        <array>
            <value>myBeforeAdvice</value>
            <value>myAfterAdvice</value>
        </array>
    </property> -->
</bean>
```