## Mybatis_21


查询缓存 -- 一级缓存(和SqlSession同时存在，同时销毁)

 * 缓存的底层实现是一个Map，Map的value是查询结果
 * Map的key，即查询依据，使用的ORM构架不同，查询依据是不同的。
 * MyBatis的查询依据是：Sql的id + SQL语句
 * Hibernate的查询依据是：查询结果对象的id
 
 
 注意: 
   * 增、删、改会对 一级缓存产生影响 --> 刷新(清空 )缓存
