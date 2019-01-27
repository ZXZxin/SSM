### SSM整合 - XML配置式开发——之使用MapperScannerConfigurer


##### (1)注意，因为IStudentDao.xml需要在dao下，所以需要改一下pom.xml文件


```xml
 <resources>
    <resource>
        <directory>src/main/java</directory>
        <includes>
            <include>**/*.xml</include>
        </includes>
  </resource>
```


##### (2)spring-mybatis配置文件要更改

```xml
<!--注册SqlSessionFactory-->
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
    <property name="configLocation" value="classpath:mybatis-config.xml"/>
    <property name="dataSource" ref="dataSource"/> <!--not value is ref-->
</bean>

<!--这个是和上一个项目　唯一不同的地方 使用MapperScannerConfigurer,不需要写id，自动为基本包生成所有代理对象-->
<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
    <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
    <property name="basePackage" value="com.zxin.dao"/>
</bean>
```

##### (3)spring-service 配置文件需要更改( 没有studentDao这个id了)

```xml
<!--注册Service-->
<bean id="studentService" class="com.zxin.services.StudentServiceImpl">
    <!--这里不能再使用studentDao(已经删除), 所以使用接口的简单类名-->
    <!-- 这里的Dao的注入需要使用ref属性，
        若Dao的接口名的前两个字母是大写，则这里的值为接口的简单类名
        若Dao的接口名的首字母是大写，第二个字母为小写，则这里的值为简单类名，但首字母要小写
     -->
    <property name="dao" ref="IStudentDao"></property>
</bean>
```

##### (4) mybatis-config配置文件需要更改


因为IStudentDao.xml放在了dao下，所以要更改mappers的配置

```xml

<!-- 注册映射文件(因为使用了MapperScannerConfigurer) -->
<mappers>
    <package name="com.zxin.dao"/>
</mappers>

```