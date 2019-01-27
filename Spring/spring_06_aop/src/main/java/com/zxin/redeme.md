
### 目录

通知: 

* aop01 : 前置通知的基本使用`MethodBeforeAdvice`， 以及在`xml`中配置切面(代理对象的基本实现);

* aop02 : 后置通知的基本使用: 注意在`MyAfterReturningAdvice`的方法中有一个返回值，可以获取， 但是不可以修改；

* aop03 : 环绕通知的基本使用: 可以修改目标方法的返回值；

* aop04 : 异常通知的基本使用

* aop05 : 使用一些自定义的异常通知

* aop06 : 为目标方法植入多个通知 : 在`xml`何种的`interceptorNames`中使用`array`

* aop07 : 没有接口就使用 `CGLIB`的代理,（Spring会自动的切换）
                 
* aop08 : 有接口下也使用`CGLIB`的方法

顾问: 

* aop9 : 名称匹配方法切入点顾问 (**NameMatchMethodPointcutAdvisor**)

* aop10 : 正则表达式方法切入点顾问 (**RegexpMethodPointcutAdvisor**)

* aop11 : 分析当前代码的冗余问题，会让配置文件冗余(多个代理代理对象)

* aop12 : `DefaultAdvisorAutoProxyCreator` 的使用

* aop13 : `BeanNameAutoProxyCreator` 的使用