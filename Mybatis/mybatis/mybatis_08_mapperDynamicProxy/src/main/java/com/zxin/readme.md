## Mybatis_08

增加: 
Mapper 动态代理: 删掉Mapper 的实现类 


* Mapper动态代理就是:  <font color = red>可以将接口的实现类删除</fonT>；
* 删除实现类的条件: 最重要的一步就是`<mapper namespace="">`里面的命名空间要改成接口(`dao`中的)全限定性类名。也就是要保证两件事: 
	* 第一个: `namespace`和接口权限定性类名相同；
	* 第二个: 下面的增删改查例如`<insert id = ""></insert>`中的`id`要和<font color = red>接口中的方法的名字是一样的；</font>





