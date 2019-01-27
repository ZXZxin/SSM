
### BeanNameAutoProxyCreator的使用

为了改进`DefaultAdvisorAutoProxyCreator`的缺陷: 

```xml
<!-- 注册自动代理生成器 -->
<bean class="org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator">
    <property name="beanNames" value="someService"/>
    <property name="interceptorNames" value="myAdvisor"/>
</bean>
<!-- 
    DefaultAdvisorAutoProxyCreator存在三个问题：
    1）不能选择目标对象
    2）不能选择切面类型，切面只能是advisor
    3）不能选择advisor，所以advisor均将被作为切面织入到目标方法
 -->
 
```
