### Spring_Web_2 (解决Spring容器(ApplicationContext创建多次的问题))


#### 需要添加的新的依赖

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-web</artifactId>
    <version>4.2.4.RELEASE</version>
</dependency>
```

一个新的类(ContextLoaderListener)
 

#### 需要做的工作


* 注册listener(在web.xml中)
    * 创建Spring容器
    * 将容器放到 application(全局属性域中)

 ```xml

<!--注册ContextLoaderListener : 注册ServletContext的监听器，完成两个工作
        1）在ServletContext被创建时，创建Spring容器对象
		2）将创建好的Spring容器对象放入到ServletContext的域属性空间
    源码中两行重要的代码: 
    if (this.context == null) {
            this.context = createWebApplicationContext(servletContext);
    }
    servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, this.context);
-->
 
<listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>

```

新的获取容器的方法

```java
// 获取到Spring容器对象
String acKey = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
ApplicationContext ac = (ApplicationContext) this.getServletContext().getAttribute(acKey);
```

默认回到/web-inf下去找 applicationContext.xml，所以需要在web.xml中配置

```xml
<!--ContextLoaderListener 默认会去web-inf下找，所以这里需要配置-->
<!--指定spring配置文件的路径以及名称-->
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
</context-param>
```


#### 一个奇怪的问题(有时需要加classpath: 有时不要加)

在spring_15中没有加 classpath ，但是在Spring_16(本项目)中一定要加上这个（可能和ContextLoaderListener有关）

```xml
<!-- 注册属性文件 -->
<context:property-placeholder location="classpath:jdbc.properties"/>

<bean id="mySqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
    <property name="configLocation" value="mybatis-config.xml"/> <!--但是这里主配置文件中已经没有了数据源了-->
    <!--所以需要配置数据源-->
    <property name="dataSource" ref="myDataSource"/>
</bean>
```

