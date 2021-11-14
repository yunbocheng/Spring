基于注解的di：通过注解的方式完成对象的创建，属性的赋值。代替xml配置文件

使用注解的步骤：
    1. 加入maven的依赖 spring-context 在加入spring-context的同时，间接加入了spring-aop的依赖。
       使用注解必须使用spring-aop依赖。

    2. 在类中加入spring的注解(多个不同功能的注解)。

    3. 在spring的配置文件中，加入一个组件扫描器的标签，说明注解在你项目中的位置。

    4. 使用注解创建对象，创建容器ApplicationContext

学习的注解：

    1. @Component
    2. @Repository
    3. @Service
    4. @Controller
    5. @Value
    6. @Autowired
    7. @Resource

