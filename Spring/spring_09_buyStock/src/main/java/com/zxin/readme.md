

### AOP(将事务作为切面织入到主业务)的应用 -- 购买股票


* 这里和教程讲的不同的是，我使用了注解注入

* 在BuyStockServiceImpl中，有一个需要回滚的异常


因为如果不会滚，下面的账户钱会减少，但是股票不会减少:

   
所以有下面的三个项目，必须要回滚


```java
	@Override
	public void buyStock(String aname, double money, String sname, int amount) throws BuyStockException{
		boolean isBuy = true;
		adao.updateAccount(aname, money, isBuy);
//		if (1 == 1) {
//			throw new BuyStockException("购买股票异常");
//		}
		sdao.updateStock(sname, amount, isBuy);
	}
```

* 注意最后需要将异常（原子性(两个必须同时成功)）提升到Service层，将事务织入到Service层, 于是就到了下面的项目
    * spring_10_buyStock_txProxyFactoryBean: 使用 Spring 的事务代理工厂管理 :TransactionProxyFactoryBean 
    * spring_11_buyStock_txAnnotation: 使用 Spring 的事务注解管理 : 通过@Transactional 注解方式，也可将事务织入到相应方法中。
    * spring_12_buyStock_aspectj : 使用 AspectJ 的 AOP 配置管理事务