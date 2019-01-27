

### MultiActionController的第二种methodNameResolver : PropertiesMethodNameResolver 


测试: 

在浏览器输入下面的地址: 

* `http://localhost:9091/mvc_12_multiActionController/my/first.do`

* `http://localhost:9091/mvc_12_multiActionController/my/second.do`



配置: 

```xml
<bean class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping">
		<property name="urlMap">
			<map>
				<entry key="/my/*.do" value-ref="myController"/>
			</map>
		</property>
	</bean>

	<!-- 注册方法名称解析器 : 指定映射关系-->
	<bean id="propertiesMethodNameResolver" class="org.springframework.web.servlet.mvc.multiaction.PropertiesMethodNameResolver">
		<property name="mappings">
			<props>
				<prop key="/my/first.do">doFirst</prop>
				<prop key="/my/second.do">doSecond</prop>
			</props>
		</property>
	</bean>
	
	<!-- 注册处理器 -->
	<bean id="myController" class="handlers.MyController">
		<property name="methodNameResolver" ref="propertiesMethodNameResolver"/>
	</bean>
```
