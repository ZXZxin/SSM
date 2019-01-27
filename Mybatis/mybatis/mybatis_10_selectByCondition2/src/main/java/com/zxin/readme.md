## Mybatis_10


这个和上一个不同的是，这里的 `dao`接口中的方法的参数

```java
  List<Student> selectStudentsByCondition(String name, int age);
```

在 `mapper.xml`中是这样写的

```xml
 <select id="selectStudentsByCondition" resultType="Student">
        select id,name,age,score
        from student
        where name like '%' #{arg0} '%'
        and age > #{arg1}
    </select>

```

也就是可以参数的序号



`#{}`中可以放什么内容？

* 1）参数对象的属性；
* 2）随意内容，此时的`#{}`是个占位符；
* 3）参数为`map`时的`key`；
* 4）参数为`map`时，若`key`所对应的`value`为对象，则可将该对象的属性放入；
* 5）参数的索引号，如 `arg0`、`arg1`;


