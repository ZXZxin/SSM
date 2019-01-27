###　类型转化之　转换Date形式



测试: index.jsp页面内输入  (注意日期格式 要输入 2016-09-25的形式)

问题引出: 


```html
 <body>
    <form action="${pageContext.request.contextPath }/test/register.do" method="POST">
    	年龄：<input type="text" name="age"/><br>
        <!--这里使用了birthday, 默认是 2016/9/24的形式，但是我需要2016-9-24所以需要类型转换器-->
    	生日：<input type="text" name="birthday"/><br> 
    	<input type="submit" value="注册"/>
    </form>
  </body>
```


主要转换后台代码: 
```java

// Converter接口中的两个泛型表示：
// 第一个：表示源的类型
// 第二个：表示宿的类型，即转换为的目标类型
public class MyDateConverter implements Converter<String, Date> {

	public Date convert(String source) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //转换成这种形式
		try {
			return sdf.parse(source);
		} catch (ParseException e) {   
			e.printStackTrace();
		}
		return null;
	}

}
```

注意类型转换器要在springmvc.xml中配置, 分三步

```xml
<!-- 注册组件扫描器 -->
	<context:component-scan base-package="com.zxin.handlers"/>
	
	<!-- (1) 注册类型转换器 -->
	<bean id="myDateConverter" class="com.zxin.converters.MyDateConverter"/>
	
	<!-- 注册转换服务对象 : (2)将类型转换器注入给转换服务Bean-->
	<bean id="conversionService" class="org.springframework.context.support.ConversionServiceFactoryBean">
		<property name="converters" ref="myDateConverter"/>
	</bean>
	
	<!-- 注册mvc注解驱动 : (3) 最后由处理器适配器来使用该转换服务Bean -->
	<mvc:annotation-driven conversion-service="conversionService"/>
```