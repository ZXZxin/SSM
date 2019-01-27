

SPEL 表达式的使用


注意在第二个bean中访问Person.pname的时候，要在Person类中要加上getter方法，不然会出错

这里的需求是: Person类的age 在[0, 50)之间

且Student的age和Person类的相同

且当Student的age > 25的时候就改成 25

```xml
    <!-- 注册School -->
    <bean id="myPerson" class="com.zxin.di09.Person">
    	<property name="pname" value="李四"/>
    	<property name="page" value="#{T(java.lang.Math).random() * 50}"/>   
    </bean>
    
    <bean id="myStudent" class="com.zxin.di09.Student">
    	<property name="name" value="#{myPerson.pname}"/>
    	<!-- <property name="age" value="#{myPerson.page > 25 ? 25 : myPerson.page}"/> -->
    	<property name="age" value="#{myPerson.computeAge() }"/>
    </bean>

```