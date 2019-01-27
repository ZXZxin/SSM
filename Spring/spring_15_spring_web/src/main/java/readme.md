### Spring和Web(view层)整合

#### 第一个问题: 

`tomcat`启动的时候访问报错

解决方案: 

在`pom.xml`的配置文件`dependency`中

下面这个句`<scope>provided</scope>`加上就可以了

```xml
<dependency>

    <groupId>javax.servlet</groupId>

    <artifactId>servlet-api</artifactId>

    <version>2.5</version>

    <scope>provided</scope> <!--这个很重要 ！！！！！！！-->

</dependency>

```



### 第二个问题: 

<!--这里如果配置了这个，配置文件就只能放在src/main/java下面的，则我原来的resources就会失效，所以会发生FileNotFindException-->

```xml
<resources>

    <resource>

        <directory>src/main/java</directory>

        <includes>

            <include>*/.xml</include>

        </includes>

    </resource>

</resources>

```



### 第三个问题: 

Tomcat插件不要放在 `<pluginManagement>`下，而是放在`<plugins>`下

### 第四个问题: 

我这里没有使用Mybatis的`MapperScannerConfigurer`配置

因为我的spring_14_spring_mybatis_2还存在问题，即`MapperScannerConfigurer`配置存在问题

所以我这里还是使用的 `MapperFactoryBean`来配置的Mybatis


### 第五个问题(直接导致下一个项目，这里的ApplicationContext ac 会创建多个(每次启动都会创建))

```java
ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
System.out.println("ac = " + ac); // 这个每次刷新一次页面(post请求)，就会创建一个容器对象
```


* 有一个思路，因为Servlet是单例的，所以只会创建一次，即init方法只会执行一次

* 但是上面的思路也不行，因为一个项目中可能有多个Servlet，所以还是会创建多个Spring容器

* 此时，又有一个新的思路，就是ServletContext这个对象也只会创建一次，而且它有一个监听器，可以监听它的启动，所以有了下一个项目