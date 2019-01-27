


### Aspect对AOP的实现，这个是很很重要的（常用）


* 前置

* 后置

* 环绕　(一定要带一个参数，　且带上返回值）



`XML`的约束要更改
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:aop="http://www.springframework.org/schema/aop" xsi:schemaLocation="
        http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop 
        http://www.springframework.org/schema/aop/spring-aop.xsd">

```


其他知识



AspectJ 除了提供了六种通知外，还定义了专门的表达式用于指定切入点。表达式的原型是：
```java
    execution ( [modifiers-pattern]	访问权限类型
        ret-type-pattern	返回值类型 // 必须的
        [declaring-type-pattern]	全限定性类名
        name-pattern(param-pattern) 方法名(参数名) //必须的
        
        [throws-pattern]	抛出异常类型 
    )
```

举例：
`execution(public * *(..))`
指定切入点为：任意公共方法。

`execution(* set *(..))`
指定切入点为：任何一个以“set”开始的方法。

`execution(* com.xyz.service.*.*(..))`
指定切入点为：定义在 service 包里的任意类的任意方法。

`execution(* com.xyz.service..*.*(..))`
指定切入点为：定义在 service 包或者子包里的任意类的任意方法。“..”出现在类名中时，后面必须跟“*”，表示包、子包下的所有类。

`execution(* *.service.*.doSome())`
指定只有一级包下的serivce 子包下所有类中的 doSome()方法为切入点execution(* *..service.*.doSome())
指定所有包下的serivce 子包下所有类中的 doSome()方法为切入点execution(* com.xyz.service.IAccountService.*(..))
指定切入点为： IAccountService 接口中的任意方法。

`execution(* com.xyz.service.IAccountService+.*(..))`
指定切入点为： IAccountService 若为接口，则为接口中的任意方法及其所有实现类中的任意方法；若为类，则为该类及其子类中的任意方法。

`execution(* joke(String,int)))`
指定切入点为：所有的 joke(String,int)方法，且 joke()方法的第一个参数是 String，第二个参数是 int。如果方法中的参数类型是 java.lang 包下的类，可以直接使用类名，否则必须使用全限定类名，如 joke( java.util.List, int)。

`execution(* joke(String,*)))`
指定切入点为：所有的 joke()方法，该方法第一个参数为 String，第二个参数可以是任意类型，如joke(String s1,String s2)和joke(String s1,double d2)都是，但joke(String s1,double d2,String s3)不是。

`execution(* joke(String,..)))`
指定切入点为：所有的 joke()方法，该方法第 一个参数为 String，后面可以有任意个参数且参数类型不限，如 joke(String s1)、joke(String s1,String s2)和 joke(String s1,double d2,String s3)
