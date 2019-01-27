


### DefaultAdvisorAutoProxyCreator的使用

```xml
 <!-- 注册自动代理生成器 -->
    <bean class="org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator"/>
```

就可以直接删除所有的代理对象: 


下面的代码可以直接删除
```xml
<!-- 生成代理对象 -->
<bean id="serviceProxy" class="org.springframework.aop.framework.ProxyFactoryBean">
    <property name="target" ref="someService"/>
    <property name="interceptorNames" value="myAdvisor"/>
</bean>

<!-- 生成代理对象 -->
<bean id="serviceProxy2" class="org.springframework.aop.framework.ProxyFactoryBean">
    <property name="target" ref="someService"/>
    <property name="interceptorNames" value="myAdvisor"/>
</bean>
```