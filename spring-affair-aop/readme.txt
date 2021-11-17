spring框架中提供的事务处理方案
1. 适合中小项目使用的，注解方案
   spring框架自己用aop实现给业务方法增加事务的功能，使用 @Transactional注解增加事务。
   @Transactional注解是spring框架自己的注解，放在public方法的上面，代表当前方法具有事务。
   可以给注解的属性赋值，表示事务的隔离级别，传播行为，异常信息等。

2. 使用方式
通过@Transactional 注解方式，可将事务织入到相应 public 方法中，实现事务管理。

@Transactional 的所有可选属性如下所示：
    propagation：用于设置事务传播属性。该属性类型为 Propagation 枚举，默认值为
                 Propagation.REQUIRED。(使用的是枚举类型)

    isolation：用于设置事务的隔离级别。该属性类型为 Isolation 枚举，默认值为
                Isolation.DEFAULT。(使用的是枚举类型)

    readOnly：用于设置该方法对数据库的操作是否是只读的。该属性为 boolean，默认值
                为 false。

    timeout：用于设置本操作与数据库连接的超时时限。单位为秒，类型为 int，默认值为
                -1，即没有时限。

    rollbackFor：指定需要回滚的异常类。类型为 Class[]，默认值为空数组。当然，若只有
                一个异常类时，可以不使用数组。

    rollbackForClassName：指定需要回滚的异常类类名。类型为 String[]，默认值为空数组。
                当然，若只有一个异常类时，可以不使用数组。

    noRollbackFor：指定不需要回滚的异常类。类型为 Class[]，默认值为空数组。当然，若
                只有一个异常类时，可以不使用数组。

    noRollbackForClassName：指定不需要回滚的异常类类名。类型为 String[]，默认值为空
                数组。当然，若只有一个异常类时，可以不使用数组。

    注意：
        需要注意的是，@Transactional 若用在方法上，只能用于 public 方法上。对于其他非 public
        方法，如果加上了注解@Transactional，虽然 Spring 不会报错，但不会将指定事务织入到该
        方法中。因为 Spring 会忽略掉所有非 public 方法上的@Transaction 注解。

    若@Transaction 注解在类上，则表示该类上所有的public方法均将在执行时织入事务。

3.是使用@Transaction的步骤
    1) 需要声明事务管理器对象
       <bean id="xxx" class="DataSourceTransactionManager">

    2) 开启事务注解驱动，告诉spring框架，我需要使用注解的方式管理事务
        spring使用aop机制，创建@Transaction所在的类代理对象，给方法加入事务的功能。

        spring给业务方法加入事务：
            在你的事务执行之前，先开启事务，在业务方法之后提交或者回滚事务，使用aop的环绕通知

            @Around(){
                开启事务
                try{
                    buy(1001,10);
                    spring的事务管理.commit();
                }catch{
                    spring的事务管理.rollback();
                }
            }