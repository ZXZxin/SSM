

通过 Spring自带的 `@AutoWired` 和 `@Qualifier`
来实现 `byName`方式的注入


```java
	@Autowired     
	@Qualifier("mySchool")   // byName方式的注解式注入，要求@Autowired与@Qualifier联合使用
	private School school;   // 对象属性，域属性

```