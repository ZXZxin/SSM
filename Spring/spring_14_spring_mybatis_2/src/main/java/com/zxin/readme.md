

### 整合Spring和Mybatis (使用 支持扫描的Mapper动态代理生成Dao代理对象)


注意注意!!!! : 这个程序还没有写成功: 

### Emmm，上面这句话作废，我好像找到原因了，把MapperScannerConfigurer里面的basePackage包配置错了, com写成了con...


参考博客: (MapperScannerConfigurer的使用注意事项)
https://blog.csdn.net/kevin_loving/article/details/80528967
http://blog.sina.com.cn/s/blog_631d3ae20102v3gt.html

下面的配置有问题

```xml
<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<!--配置需要的sqlSessionFactory-->
		<property name="sqlSessionFactoryBeanName" value="mySqlSessionFactory"/>
		<!--指定基本包-->
		<property name="basePackage" value="con.zxin.dao"/>
	</bean>

	<!--<context:component-scan base-package="com.zxin.*"/>-->
	<!--&lt;!&ndash; 注册Service &ndash;&gt;-->
	<bean id="studentService" class="com.zxin.service.StudentServiceImpl">
		<!--这里不能再使用studentDao(已经删除), 所以使用接口的简单类名-->
		<!-- 这里的Dao的注入需要使用ref属性，
			若Dao的接口名的前两个字母是大写，则这里的值为接口的简单类名
			若Dao的接口名的首字母是大写，第二个字母为小写，则这里的值为简单类名，但首字母要小写
		 -->
		<!--<property name="dao" ref="studentDao"/>-->
		<property name="dao" ref="IStudentDao"/> <!--这里有问题-->
	</bean>
```


上一个项目(spring_13_spring_mybatis)的缺点: 

*  生成代理的时候的缺点: MapperFactoryBean一次只能生成一个代理对象, 

* 即若有多个dao接口需要代理对象，则需要配置多个Mapper动态代理对象，这将使得配置文件变得臃肿; 


* 所以这里使用**MapperScannerConfigurer**


  