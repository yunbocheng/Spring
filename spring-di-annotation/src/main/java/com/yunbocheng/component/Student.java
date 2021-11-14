package com.yunbocheng.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor

/*
* @Component：这个注解是用来创建对象的，等同于applicationContext.xml配置文件中的<bean>
*    属性 value ： 对象的名称，也就是bean的id值，是唯一的，不可以重复。
*
*   创建的对象在spring容器中就一个，也就是说整个项目中只有一个叫做myStudent的对象。
*
*   位置 ：这个注解在实体类的上边，代码创建的是这个实体类的对象
*
*   @Component(value = "myStudent")
*   等同于
*   <bean id="myStudent" class="com.yunbocheng.component.Student">

*  使用注解的这种方式也是使用实体类的无参构造方法创建的对象
*
*  spring中和@Component功能一致，创建对象的注解还有：
*  1. @Repository（用在持久层类的上面）：放在dao的实现类上面，
*       表示创建dao对象，dao对象是访问数据库的。
*  2. @Service（用在业务层类的上面）：放在service的实现类上面，
*       创建service对象，service对象是做业务处理的，可以有事务处理等功能。
*  3. @Controller（用在控制器的上面）：放在控制器(处理器)类的上面，创建控制器对象的
*       控制器对象，能够接受用户提交的参数，显示请求的处理结果。
*
* 以上三个注解的使用语法和@Component是一样的。都是创建对象，但是这三个注解还有额外的功能。
* @Repository、@Service、@Controller是给项目的对象分层的。这三个注解的基本功能是一样的，但是额外的功能是不一样的。
*
* 当我们不确定这个实体类是属于什么层的时候，就是用@Component注解。
*
* */

// 注解不可以重复使用，一个类上的一种注解只能存在一个
// 使用value来指定对象名称
// @Component(value = "myStudent")

// 省略value，实际开发中这么写
@Component("myStudent")

// 不指定对象名称，由spring提供默认名称，这个名称是类名称的首字母小写。
// @Component
public class Student {
    private String name;
    private Integer age;
}
