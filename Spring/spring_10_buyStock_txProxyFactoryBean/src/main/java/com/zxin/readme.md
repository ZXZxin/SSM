

### 使用 Spring 的事务代理工厂管理 :TransactionProxyFactoryBean 将事务织入到业务中

使用 Spring 的事务代理工厂管理 :TransactionProxyFactoryBean 


* 注意: Spring默认的回滚方式是: 当发生受查异常时提交；发生运行时异常回滚



所以需要配置xml:

下面的`-BuyStockException`很重要，表示指定异常当发生时，会发生回滚(数据库内容不会改变)

```xml
<!-- 
    -异常：表示发生指定异常后回滚，这时的异常通常是受查异常
    +异常：表示发生指定异常后提交，这时的异常通常是运行时异常
-->
<prop key="buyStock">ISOLATION_DEFAULT,PROPAGATION_REQUIRED, -BuyStockException</prop>
```