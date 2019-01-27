 
 
 
### 异常通知的基本使用


注意ThrowAdvice中有四个方法: 

我们只需要按自己的需求重写即可

```java

public void afterThrowing(Exception ex);
public void afterThrowing(RemoteException);
public void afterThrowing(Method method, Object[] args, Object target, Exception ex);
public void afterThrowing(Method method, Object[] args, Object target, ServletException ex);
```
 
 