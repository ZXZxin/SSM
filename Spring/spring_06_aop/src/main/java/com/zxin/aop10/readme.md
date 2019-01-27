

### 正则表达式方法切入点顾问 (RegexpMethodPointcutAdvisor)


* 注意:
    * 这里的正则表达式匹配的对象是**全限定性方法名**；
    * 前面的名称匹配方法是指定切入点：这里匹配的对象是**简单方法名**；]
    

* 注意注意:

    * 注意一定是 全限定性方法名，这里最后我们想只增强``doSecond`但是，最后都增强了，因为是全限定性方法名;
    * `com.zxin.aop10.ISomeService.doSecond` 这里前面就有两个`S`了;
    
    
`xml`配置

```xml
 <!-- 注册切面：通知 -->
    <bean id="myAdvice" class="com.zxin.aop10.MyAfterReturningAdvice"/>
    
    <!-- 注册切面：顾问 -->
    <bean id="myAdvisor" class="org.springframework.aop.support.RegexpMethodPointcutAdvisor">
    	<property name="advice" ref="myAdvice"/>
    	<!-- 这里的正则表达式匹配的对象是全限定性方法名 -->
    	<!-- <property name="pattern" value=".*doFirst"/> -->
    	<!-- <property name="patterns" value=".*doFirst,.*doSecond"/> -->
    	<!-- <property name="pattern" value=".*doFirst|.*doSecond"/> --> <!--和上面那个效果一样-->
    	<property name="pattern" value=".*S.*"/>
    </bean>
    
    <!-- 生成代理对象 --> 
    <bean id="serviceProxy" class="org.springframework.aop.framework.ProxyFactoryBean">
    	<property name="target" ref="someService"/>
    	<property name="interceptorNames" value="myAdvisor"/>
    </bean>
```