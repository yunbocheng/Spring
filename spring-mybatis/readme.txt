spring-mybatis:spring和mybatis的继承

步骤：
    1. 新建Maven
    2. 加入maven依赖
        1) spring依赖
        2) mybatis依赖
        3) mysql驱动
        4) spring的事务的依赖
        5) mybatis和spring集成的依赖：mybatis官方提供的，用来在spring项目中创建mybatis
           的sqlSessionFactory、dao对象的。

    3. 创建实体类
    4. 创建dao接口和mapper文件
    5. 创建mybatis主配置文件
    6. 创建service接口和实现类
    7. 创建spring的配置文件：声明mybatis的对象交给spring创建
        1) 数据源 DataSource druid（德鲁依）
        2) SqlSessionFactory
        3) Dao对象
        4) 声明自定义的service
    8. 创建测试类，获取service对象，通过service调用dao完成数据库的访问
