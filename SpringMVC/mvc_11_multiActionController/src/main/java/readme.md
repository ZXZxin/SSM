

## (重点)MultiActionController的时候(通过方法名来指定访问路径(多个))


测试: 在浏览器分别输入下列地址: 

* http://localhost:9091/mvc_11_multiActionController/my/doFirst.do

* http://localhost:9091/mvc_11_multiActionController/my/doSecond.do


**该解析器将方法名作为资源名称进行解析**
```xml
<bean class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping">
    <property name="urlMap">
        <map>
    <!-- MultiActionController类具有一个属性methodNameResolver，方法名解析器
        其具有默认值InternalPathMethodNameResolver，该解析器将方法名作为资源名称进行解析，
        那就意味着，我们提交请求时，要将方法名作为资源名称出现
     -->
            <entry key="/my/*.do" value-ref="myController"/>
        </map>
    </property>
</bean>
```