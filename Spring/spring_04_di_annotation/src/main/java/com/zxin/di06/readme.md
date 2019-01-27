

使用Spring提供的测试junit来测试

在测试类的上面要添加这个


```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext6.xml")
```