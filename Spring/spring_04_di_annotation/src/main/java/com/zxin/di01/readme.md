
简单的使用注解的注入

* 简单的使用Component，来代替bean的注册;

* 然后在属性上的value就是注入属性的值 ，注意一定要注册一个组件扫描器的东西;

* 用到的注解 : ① 在需要注册的类上添加`@Component`，在属性上添加`@Value`;
补充: 和`@Component`类似的几个注解:与@Component注解功能相同，但意义不同的注解还有三个：
    * 1)@Repository：注解在Dao实现类上
    * 2)@Service：注解在Service实现类上
    * 3)@Controller：注解在SpringMVC的处理器上


* 一定要在xml配置文件中添加一个组件扫描器的东西;

* 要添加组件扫描器，就需要在xml约束文件中添加`context schema`的约束;

* 因为注解底层用到`aop`，所以也需要导入`aop`的`jar`包;

* 域属性注入这里用的是 默认的`byType`注入(查找具有is-a关系的)，使用`Autowired`;