

重点!!!


`autowire`自动注入域属性(引用)


`autowire="byName"` 会从容器中查找与实体类的域属性同名的Bean的id，
并将该Bean对象自动注入给该域属性


所以在 所以在xml中装配的bean的id 要和 要注入的类的属性的名称是一样的


```xml
    <!-- 自动注入，所以这里的school 必须和Student类中的属性的名称是一样的 -->
    <bean id="school" class="com.zxin.di07.School">
    	<property name="name" value="清华大学"/>
    </bean>
    
    <!-- 注册Student
    	autowire="byName" 会从容器中查找与实体类的域属性同名的Bean的id，并将该Bean对象自动注入给该域属性
     -->
    <bean id="myStudent" class="com.zxin.di07.Student" autowire="byName">
    	<property name="name" value="张三"/>
    	<property name="age" value="23"/>
    </bean>
```