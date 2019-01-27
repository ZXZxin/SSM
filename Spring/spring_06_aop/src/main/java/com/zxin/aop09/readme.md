

### 顾问的基本使用


* 通知和顾问的区别

    * 通知中所有的连接点都是切入点；
    * 在顾问中，可以指定某些连接点为切入点，其他的不指定为切入点；比如说只增强doFirst，不增强doSecond
    

    
这个案例使用的是基本的名称匹配方法顾问 (**NameMatchMethodPointcutAdvisor**) : 

*  这里只增强了doFirst和doThird方法，没有增强doSecond()方法


只需要在xml中配置即可: 

* 注意, 顾问是将通知给包装了，所以需要先配置通知，然后配置顾问；

```xml
    <!-- 注册切面：通知 -->
    <bean id="myAdvice" class="com.zxin.aop09.MyAfterReturningAdvice"/>
    
    <!-- 注册切面：顾问 -->
    <bean id="myAdvisor" class="org.springframework.aop.support.NameMatchMethodPointcutAdvisor">
    	<property name="advice" ref="myAdvice"/>
    	<!-- 指定切入点(增强的方法)：这里匹配的对象是简单方法名 -->
    	<!-- <property name="mappedName" value="doFirst"/> -->
    	<!-- <property name="mappedNames" value="doFirst,doSecond"/> -->
    	<property name="mappedNames" value="*ir*"/>
    </bean>
    
    <!-- 生成代理对象 -->
    <bean id="serviceProxy" class="org.springframework.aop.framework.ProxyFactoryBean">
    	<property name="target" ref="someService"/>
    	<property name="interceptorNames" value="myAdvisor"/>
    </bean>

```