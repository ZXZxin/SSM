### 将ssm-xml-2　的SpringMVC部分更改为　注解式开发



#### 巨他妈奇怪!!!!!!

上一个项目那个IStudentDao.xml我在pom.xml中加上了下面的代码。没有任何问题

但这里加上就会报FileNotFoundException！！！！！！！，所以不能加!!!!!

```xml
<!--<resources>-->
        <!--<resource>-->
            <!--<directory>src/main/java</directory>-->
            <!--<includes>-->
                <!--<include>**/*.xml</include>-->
            <!--</includes>-->
        <!--</resource>-->
 <!--</resources>-->
```


#### (1)第一个地方 spring-mvc.xml文件不需要注册 StudentController，而是添加组件扫描


```xml
    <!--&lt;!&ndash;注册处理器 注意id和表单访问路径一致&ndash;&gt;-->
    <!--<bean id="/zxin/register.do" class="com.zxin.handlers.StudentController">-->
        <!--<property name="service" ref="studentService"/>-->
    <!--</bean>-->

    <!--上面的配置不需要了，需要配置组件扫描器-->
    <context:component-scan base-package="com.zxin.handlers"/>

```


##### (2)第二个地方 StudentController，需要改成注解


##### 这里有一个很重要的点: 因为我们之前将Service注入到Controller，所以现在需要用注解注入Service

```java
@Controller
@RequestMapping("/zxin")
public class StudentController {

    // 将IStudentService 注入到Controller
    @Autowired
    @Qualifier("studentService")
//    @Resource(name = "studentService")
    private IStudentService service;

    // 为了构造注入
    public void setService(IStudentService service) {
        this.service = service;
    }

    @RequestMapping("/register.do")
    public String handleRequest(String name, int age) throws Exception {
        Student student = new Student(name, age);
        service.addStudent(student);
        return "/welcome.jsp";
    }
}

```