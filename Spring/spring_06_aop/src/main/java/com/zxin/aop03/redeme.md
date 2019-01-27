

### 环绕通知的基本使用(Jar包不是Spring的，而是AOP联盟的)

* 基本思想就是在目标方法执行之前和之后都可以执行；

* 这里注意中间的那个方法不是动态代理里面的那个`invoke`方法，而是`proceed()`方法；

* 因为这个``invoke`方法和后置通知的不同的是，这里有返回值，所以这里可以修改那个值了。

```java

// 环绕通知：可以修改目标方法的返回结果
public class MyMethodInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("执行环绕通知：目标方法执行之前");
		// 执行目标方法
		Object result = invocation.proceed();
		System.out.println("执行环绕通知：目标方法执行之后");
		if(result != null) {
			result = ((String)result).toUpperCase();
		}
		return result;
	}
}

```