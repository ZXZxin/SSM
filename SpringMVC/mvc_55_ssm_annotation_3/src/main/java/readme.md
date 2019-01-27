### 将Mybatis改成注解(不建议,ssm2是最好的ssm整合)


#### 巨他妈的奇怪，这里又需要加上pom.xml文件

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

#### 只需要改 IStudentDao.xml文件

删掉 IStudentDao.xml文件

```java
public interface IStudentDao {

    @Insert("insert into student(name,age) values(#{name},#{age})")
    public void insertStudent(Student student);

}

```

