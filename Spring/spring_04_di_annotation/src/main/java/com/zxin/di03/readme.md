

di03 : JSR-250 规范中定义`@Resource` 标准注解的实现对域属性的注入


改变: 


```java
	// @Resource(name="mySchool")   // byName方式的注解式注入
	@Resource   // byType方式的注解式注入
	private School school;   // 对象属性，域属性
```