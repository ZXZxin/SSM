

Bean后处理器

BeanPostProcesser 
(需要在Spring容器中装配)



* 其他任何Bean在初始化完毕之前会调用这个方法　postProcessBeforeInitialization()
* 其他任何Bean在初始化完毕之后会调用这个方法  postProcessAfterInitialization()



配合动态代理来实现某一些增强的功能

这个程序是只增强 MyService的doSome()方法, MyService的doOther()不增强，MyService2也不增强

```java
    // bean：表示当前正在进行初始化的Bean对象
	// beanName：表示当前正在进行初始化的Bean对象的id
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("执行 ----before---()方法");
		return bean;
	}
```
