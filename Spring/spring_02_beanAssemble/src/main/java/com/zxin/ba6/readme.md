

测试 Bean 的整个生命周期: 

 
程序输出: 
     
     Step1：执行无参构造器
     Step2：执行setter
     Step2：执行setter
     Step3：获取到bean的id = myService
     Step4：获取到BeanFactory容器
     Step5：执行 ----before---()方法
     Step6：Bean初始化完毕了
     Step7：初始化完毕之后
     Step8：执行 ----after---()方法
     Step9：执行doSome()方法
     Step10：实现接口的销毁之前
     Step11：销毁之前
