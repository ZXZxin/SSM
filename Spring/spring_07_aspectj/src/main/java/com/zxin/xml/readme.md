

### 基于XML的AspectJ


就是下面的配置替代了注解 
```xml
<!-- AOP配置 -->
	<aop:config>
	    <!--定义一些切入点表达式　下面的切面中要使用-->
		<aop:pointcut expression="execution(* *..ISomeService.doFirst(..))" id="doFirstPointcut"/>
		<aop:pointcut expression="execution(* *..ISomeService.doSecond(..))" id="doSecondPointcut"/>
		<aop:pointcut expression="execution(* *..ISomeService.doThird(..))" id="doThirdPointcut"/>
		
		<!--定义切面 注意下面的不能用id 而是 ref-->
		<aop:aspect ref="myAspect">
			<aop:before method="myBefore" pointcut-ref="doFirstPointcut"/>
			<aop:before method="myBefore(org.aspectj.lang.JoinPoint)" pointcut-ref="doFirstPointcut"/>
			
			<aop:after-returning method="myAfterReturning" pointcut-ref="doSecondPointcut"/>
			<aop:after-returning method="myAfterReturning(java.lang.Object)" pointcut-ref="doSecondPointcut" returning="result"/>
			
			<aop:around method="myAround" pointcut-ref="doSecondPointcut"/>
			
			<aop:after-throwing method="myAfterThrowing" pointcut-ref="doThirdPointcut"/>
			<aop:after-throwing method="myAfterThrowing(java.lang.Exception)" pointcut-ref="doThirdPointcut" throwing="ex"/>
			
			<aop:after method="myAfter" pointcut-ref="doThirdPointcut"/>
		</aop:aspect>
	</aop:config>
```