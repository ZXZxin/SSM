### 将SpringMVC和Spring都改成注解 (重点重点重点 IOC和AOP都要改)


### 真他妈的奇怪，这里又一定需要添加下面这个，不然又会报错

相关博客`https://www.cnblogs.com/lfm601508022/p/InvalidBoundStatement.html`

```xml
 <resources>
    <resource>
        <directory>src/main/java</directory>
        <includes>
            <include>**/*.xml</include>
        </includes>
    </resource>
</resources>
```


##### (1)废弃Service的注册，添加`@Service`注解


* 包括添加`@Service`注解

* 将aop配置删除之后，要添加`@Transactional`注解

```java
@Service("studentService")
public class StudentServiceImpl implements IStudentService {

    @Resource(name = "IStudentDao")
    private IStudentDao dao;

    // 为了构造注入
    public void setDao(IStudentDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public void addStudent(Student student) {
        dao.insertStudent(student);
    }
}
```

`spring-service.xml`，只需要配置一个组件扫描器**注意一定要配置，不能和SpringMVC合在一起**
```xml

<!--将Spring改成注解:  Service不需要了，注意这里不能和SpringMVC的组件扫描器合在一起-->
<context:component-scan base-package="com.zxin.services"/>

<!--&lt;!&ndash;注册Service&ndash;&gt;-->
<!--<bean id="studentService" class="com.zxin.services.StudentServiceImpl">-->
    <!--&lt;!&ndash;这里不能再使用studentDao(已经删除), 所以使用接口的简单类名&ndash;&gt;-->
    <!--&lt;!&ndash; 这里的Dao的注入需要使用ref属性，-->
        <!--若Dao的接口名的前两个字母是大写，则这里的值为接口的简单类名-->
        <!--若Dao的接口名的首字母是大写，第二个字母为小写，则这里的值为简单类名，但首字母要小写-->
     <!--&ndash;&gt;-->
    <!--<property name="dao" ref="IStudentDao"></property>-->
<!--</bean>-->

```


#### (2)AOP


`spring-tx.xml`配置:　删除aop的一些配置


**需要添加事务注解驱动tx:annotation-driven**
```xml
<!-- aop 配置 -->

<!-- (1) 先注册事务管理器 -->
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource"/>
</bean>


<!--使用注解，下面的都不需要了, 但是需要添加事务注解驱动-->
<tx:annotation-driven transaction-manager="transactionManager"/>

<!--&lt;!&ndash;事务通知&ndash;&gt;-->
<!--<tx:advice id="txAdvice" transaction-manager="transactionManager">-->
    <!--<tx:attributes>-->
        <!--&lt;!&ndash;这里只是指定连接点&ndash;&gt;-->
        <!--<tx:method name="add*" isolation="DEFAULT" propagation="REQUIRED"/>-->
    <!--</tx:attributes>-->
<!--</tx:advice>-->

<!--&lt;!&ndash; (2) aop 配置&ndash;&gt;-->
<!--<aop:config>-->
    <!--<aop:pointcut id="studentPointCut" expression="execution(* *..service.*.*(..))"/>-->
    <!--<aop:advisor advice-ref="txAdvice" pointcut-ref="studentPointCut"/>-->
<!--</aop:config>-->

```

(2)添加　`@Transactional`（之前说过了）

```java
@Service("studentService")
public class StudentServiceImpl implements IStudentService {

    @Resource(name = "IStudentDao")
    private IStudentDao dao;

    // 为了构造注入
    public void setDao(IStudentDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public void addStudent(Student student) {
        dao.insertStudent(student);
    }
}
```