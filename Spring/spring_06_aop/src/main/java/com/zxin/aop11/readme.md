

### 当前代码存在的问题


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

当前的代码存在两个问题：
1）若存在多个目标对象，就需要使用多次ProxyFactoryBean来创建多个代理对象，这会使配置文件变得臃肿，不便于管理
2）用户真正想调用的是目标对象，而真正可以调用的却是代理对象，这不符合正常的逻辑
以上这两个问题，均为ProxyFactoryBean类的功能太简单引起的。
