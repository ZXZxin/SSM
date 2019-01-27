

这个很重要： JavaConfig类替代xml: Spring容器的配置


* 在配置类上加上 `@Configuration `这个注解；

* 也要在配置文件xml中添加 组件扫描器 ;

* `@Bean(name="myStudent", autowire=Autowire.BY_NAME)`


```xml
	<context:component-scan base-package="com.zxin.di05"/>
```

配置类代码: 
```java

@Configuration    // 表示当前类充当Spring容器，即所有的Bean将由这个类来创建
public class MyJavaConfig {
	
	@Bean(name="school")
	public School mySchoolCreator() {
		return new School("北京大学");
	}
	
	// autowire=Autowire.BY_TYPE 指从当前类这个容器中查找与域属性的类型具有is-a关系的Bean
	/*
	@Bean(name="myStudent", autowire=Autowire.BY_TYPE)
	public Student myStudentCreator() {
		return new Student("张三", 23);
	}
	*/
	
	// autowire=Autowire.BY_NAME 指从当前类这个容器中查找与域属性同名的Bean
	@Bean(name="myStudent", autowire=Autowire.BY_NAME)
	public Student myStudentCreator() {
		return new Student("张三", 23);
	}
}

```