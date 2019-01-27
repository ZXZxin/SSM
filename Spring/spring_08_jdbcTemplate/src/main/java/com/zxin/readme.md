

### 使用Spring + JDBCTemplate(类似Mybatis)完成简单的增删改查(IOC的应用)


配置文件层次关系　：　数据源  -注入--->  JDBCTemplate  -注入---> Dao  -注入---> Service

几个注意点:

* 这里的dao层和service的方法是一样的，因为这里没有上面业务，只是实现简单的增删改查，所以不需要改;

* 这里dao的实现类 StudentDaoImpl 需要继承自JDBC模板中的一个类 `JdbcDaoSupport`;

* 注意JdbcDaoSupport类有一个属性 `JdbcTemplate`可以支持操作，　但是只有`update`，没有insert、delete;

* 这里注意 不仅要注册 Dao和Service的实现类，而且需要在xml中注册JdbcTemplate的实现类, 并注入到dao的实现类中;


* 注册了JdbcTemplate之后，还需要注册一个它的属性，　即: 数据源


* 这里数据源有三种: ①JDBC的默认的数据源(DriverManagerDataSource)　②C3P0(ComboPooledDataSource)　③　DBCP(BasicDataSource)

* JDBC的四要素属性文件需　导入到 Spring配置文件中， ①　导入context标签 ,并用 <context:property-placeholder> ② 用 PropertyPlaceholderConfigurer (不常用)

* 注意　有一个RowMapper和Mybatis里面的 resultMap类似;
    * 可以封装，所以我们在调用方法的是要调用 query()方法；
    * 但是这个需要我们自己写一个StudentRowMapper,这个类实现RowMapper接口，里面有个mapRow方法;
    * 之一mapRow的参数中, ResultSet rs，不是总的结果集，而是每一次的一样数据，而不是所有查询结果集;
    
    
* 注意注意: JDBC模板对象是多例的:
    * 系统会为每一个使用魔板对象的线程(方法)创建一个JdbcTemplate实例，并且在方法结束之后就会释放这个对象;
    * 所以不能作为成员变量获取一次使用多次,