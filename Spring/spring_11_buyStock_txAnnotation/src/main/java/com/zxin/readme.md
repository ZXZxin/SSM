

### 使用 Spring 的事务注解管理将事务织入到主业务 


: 通过@Transactional 注解方式，也可将事务织入到相应方法中。

* 这里有一个福利，就是这里的约束包含了 `bean、context、tx、aop`的;
