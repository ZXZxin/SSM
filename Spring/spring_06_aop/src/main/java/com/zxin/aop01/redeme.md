

前置通知的配置

`MethodBeforeAdvice`


```java
// 前置通知
public class MyMethodBeforeAdvice implements MethodBeforeAdvice {

	// 当前方法在目标方法执行之前执行
	// method： 目标方法
	// args： 目标方法的参数列表
	// target： 目标对象
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		// 对于目标方法的增强代码就应该写在这里
		System.out.println("执行前置通知方法");
	}

}

```

`xml`配置动态代理对象: 

```xml
  <!-- 注册目标对象 -->
    <bean id="someService" class="com.zxin.aop01.SomeServiceImpl"/>
    
    <!-- 注册切面：通知 -->
    <bean id="myAdvice" class="com.zxin.aop01.MyMethodBeforeAdvice"/>

    <!-- 生成代理对象 -->
    <bean id="serviceProxy" class="org.springframework.aop.framework.ProxyFactoryBean"> <!--这个是代理工厂Bean-->
        <!--需要配置target以及interceptorNames两个属性-->
    	<!-- <property name="targetName" value="someService"/> -->
    	<!-- 指定要代理的目标对象 -->
    	<property name="target" ref="someService"/>
    	<!-- 指定切面 (拦截器) -->
    	<property name="interceptorNames" value="myAdvice"/>
    </bean>
```