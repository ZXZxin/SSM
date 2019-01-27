###  数据初始化绑定 - 另一种解决数据转换的问题

#### 简单的转换  - 和mvc_39_typeConverter1类似


之前注册的转换器可以去掉，只需要加上下面的简单的代码即可。


```java
@InitBinder
public void initBinder(WebDataBinder binder) {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
}
```