

### 整合Spring和Mybatis (使用MapperFactoryBean生成Dao代理对象)



* 注意此时的事务代理器在Spring的配置文件中已经存在，所以在mybatis主配置文件中不需要配置了；

* Mybatis中的重量级对象SqlSessionFactoryBean交给Spring容器来管理，因为Spring默认的创建刚好是
  `singleton`的(scope)，所以刚好SqlSessionFactory也只需要创建一次(就不需要关闭了)
  
  
  
比较新的配置: 

```xml
	<bean id="mySqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<!--
			需要配置mybatis主配置文件的路径,相当于下面的代码
		 	inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            // 2. 创建sqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); //在build的时候就会自己关闭inputStream(源码中)
            // 3. 创建 sqlSession
            sqlSession = sqlSessionFactory.openSession();
		-->
		<property name="configLocation" value="classpath:mybatis-config.xml"/> <!--但是这里主配置文件中已经没有了数据源了-->
		<!--所以需要配置数据源-->
		<property name="dataSource" ref="myDataSource"/>
	</bean>
	
	<!-- 生成Dao的代理对象 -->
	<bean id="studentDao" class="org.mybatis.spring.mapper.MapperFactoryBean">
		<!--配置需要的sqlSessionFactory-->
		<property name="sqlSessionFactory" ref="mySqlSessionFactory"/>
		<!--这个就是那个需要代理的dao-->
		<property name="mapperInterface" value="com.zxin.dao.IStudentDao"/>
	</bean>
	
```
  