## Mybatis_23



注解: 和类是一个层级的


* 注解里面如果是一个数组要用{}括起来，如果数组只有一个元素，就可以省略大括号；
* 如果注解里面是value属性，也可以省去；


* 注解配置有一个很重要的地方，就是我们虽然删除了映射文件，但是主配置文件中还是要配置<mapper>标签，用package


这个不配置就会出错
```xml
    <mappers>
        <package name="com.zxin.dao"></package>
        <!--<mapper resource="StudentMapper.xml"/>-->
    </mappers>
```