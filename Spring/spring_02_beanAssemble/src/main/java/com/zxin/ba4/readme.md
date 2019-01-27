

这里要区分创建bean 的两种设计模式

 * 单例模式 : 只创建一个，下次获取的时候还是同样的对象；
 * 原型模式: 每次都重新创建一个
  
 
 
`scope="prototype"` 原型模式，其对象的创建时机不是在Spring容器初始化时创建，而是在代码中真正访问时才创建
`scope="singleton"` 单例模式，其对象的创建时机是在Spring容器初始化时创建，是默认值


当通过 Spring 容器创建一个 Bean 实例时，不仅可以完成 Bean 的实例化，还可以通过scope 属性，为 Bean 指定特定的作用域。Spring 支持 5 种作用域。

* （1）singleton：单态模式。即在整个 Spring 容器中，使用 singleton 定义的Bean 将是单例的，只有一个实例。默认为单态的。
* （2）prototype：原型模式。即每次使用 getBean 方法获取的同一个<bean />的实例都是一个新的实例。
* （3）request：对于每次HTTP 请求，都将会产生一个不同的 Bean 实例。
* （4）session：对于每个不同的 HTTP session，都将产生一个不同的 Bean 实例。
* （5）global session：每个全局的 HTTP session 对应一个Bean 实例。典型情况下，仅在使用portlet 集群时有效，多个 Web 应用共享一个session。一般应用中，global-session 与 session 是等同的。

注意：
* （1）对于 scope 的值 request、session 与 global session，只有在 Web 应用中使用 Spring 时，该作用域才有效。
* （2）对于 scope 为 singleton 的单例模式，该 Bean 是在容器被创建时即被装配好了。
* （3）对于 scope 为 prototype 的原型模式，Bean 实例是在代码中使用该 Bean 实例时才进行装配的。