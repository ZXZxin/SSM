
HandlerMapping 接口负责根据 request 请求找到对应的 Handler 处理器及 Interceptor 拦

截器，并将它们封装在 HandlerExecutionChain 对象中，返回给中央调度器。
其常用的实现类有两种：
BeanNameUrlHandlerMapping(默认的)

### 这个项目演示的就是第二种 HandlerMapping实现类(可以实现一个Controller对应多个路径)

使用BeanNameUrlHandlerMapping 映射器有两点明显不足：

处理器 Bean 的 id 为一个 url 请求路径，而不是 Bean 的名称，有些不伦不类。
处理器Bean 的定义与请求url 绑定在了一起。若出现多个url 请求同一个处理器的情况， 就需要在 Spring 容器中配置多个该处理器类的<bean/>。这将导致容器会创建多个该处理器类实例。

SimpleUrlHandlerMapping 处理器映射器，不仅可以将 url 与处理器的定义分离，还可以对 url 进行统一映射管理。
SimpleUrlHandlerMapping 处理器映射器，会根据请求的 url 与 Spring 容器中定义的处理器映射器子标签的key 属性进行匹配。匹配上后，再将该 key 的value 值与处理器 bean 的 id 值进行匹配，从而在spring 容器中找到处理器 bean。


#### 只需要将配置加上如下, MyController就可以匹配下面几个路径

```xml
<!-- 注册HandlerMapping -->
	<bean class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping">
		<property name="urlMap">
			<map>
				<entry key="/my.do" value="myController"/>
				<entry key="/hello.do" value="myController"/>
			</map>
		</property>
		<!-- <property name="mappings">
			<props>
				<prop key="/my.do">myController</prop>
				<prop key="/hello.do">myController</prop>
			</props>
		</property> -->
	</bean>

```