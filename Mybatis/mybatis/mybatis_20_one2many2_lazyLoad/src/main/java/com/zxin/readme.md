## Mybatis_20


介绍的是延迟加载: 

* 需要在主配置文件 mybatis-config.xml文件中配置
* 分为三种: 
    * 直接加载(不需要配置(默认)): 执行完对主加载对象的select语句，马上执行对关联对象的select查询
    * 侵入式加载: 
    * 深度延迟: 只有当真正访问关联对象的详情时， 才会执行对关联对象的select查询 
    

配置: 

```xml
    <!--开启延迟加载  这个默认是侵入式的-->
    <settings>
        <setting name="lazyLoadingEnabled" value="true"/>
    </settings>
```