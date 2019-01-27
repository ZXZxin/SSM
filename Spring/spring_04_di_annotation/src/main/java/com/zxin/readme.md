## 基于注解的依赖注入(DI-Annotation)(重点)


注意注意: 注解的注入不是基于setter方法，也不是基于构造注入，是另外的注入方式

### 目录

* di01 : 简单的使用Component，来代替bean的注册，然后在属性上的value就是注入属性的值 ，注意一定要注册一个组件扫描器的东西；

* di02(重点) : 通过 Spring自带的 `@AutoWired` 和 `@Qualifier`来实现 `byName`方式的注入

* di03 : JSR-250 规范中定义`@Resource` 标准注解的实现对域属性的注入

* di04(了解即可) : Bean 的生命始末@PostConstruct 与@PreDestroy

* di05(重点) : JavaConfig类(替代xml配置文件)

* di06(重点) : 使用Spring提供的测试Juint来测试

* di07: XML和注解同时存在的情况下: XML的优先级要高于注解



