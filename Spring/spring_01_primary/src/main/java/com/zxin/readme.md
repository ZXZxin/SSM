# Spring_01


简单的使用了一下IOC的配置，就是让Spring容器(xml文件)帮我们去创建bean(实现类)


* 这样可以实现解耦，因为test测试类中就看不到SomeServiceImpl,这个就是解耦
* 注意　SomeServiceImpl有一个id, 在测试类中先获取容器,然后通过容器的getBean方法获取bean


一个面试点: 

 ApplicationContext与BeanFactory容器的区别：
 这两上容器对于其中Bean的创建时机不同：(在程序中加一个断点就可以发现 (并在实现类的无参构造器中输出一句话))
 * 1）ApplicationContext容器在进行初始化时，会将其中的所有Bean(对象)进行创建
      缺点：占用系统资源（内存、CPU等）
      优点：响应速度快
 * 2）BeanFactory容器中的对象，在容器初始化时并不会被创建，而是在真正获取该对象时才被创建
      缺点：相对来说，响应速度慢
      优点：不多占用系统资源