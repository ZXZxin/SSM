

### 使用AspectJ来将事务注入到主业务中

配置:


```xml
<bean id="myTransactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref = "myDataSource"></property>
	</bean>

	<!--定义事务通知-->
	<tx:advice id="txAdvice" transaction-manager="myTransactionManager">
		<tx:attributes>
		    <!--这里指定的是为每一个连接点指定所要应用的事务属性-->
			<tx:method name="open*" isolation="DEFAULT" propagation="REQUIRED"/>
			<tx:method name="buyStock" isolation="DEFAULT" propagation="REQUIRED" rollback-for="BuyStockException"/>
		</tx:attributes>
	</tx:advice>

	<!--AspectJ的AOP配置-->
	<aop:config>
		<!--
			(*  *..service.*.*(..))
			意义：
				* 返回值
				* .. 多级包
				service 包下的
				.* 所有类或者接口
				.* 所有方法名
		-->
		<!--指定切入点-->
		<!--<aop:pointcut id="myPointcur" expression="execution(* *..service.*.open*(..))"></aop:pointcut>--><!--如果是这样，上面配置的属性就只有open*的连接点才能成为切入点-->
		<aop:pointcut id="myPointcur" expression="execution(* *..service.*.*(..))"></aop:pointcut>
		<aop:advisor advice-ref="txAdvice" pointcut-ref="myPointcur"/>
	</aop:config>
```

注意:
```xml
<!--<aop:pointcut id="myPointcur" expression="execution(* *..service.*.open*(..))"></aop:pointcut>--><!--如果是这样，上面配置的属性就只有open*的连接点才能成为切入点-->
```
