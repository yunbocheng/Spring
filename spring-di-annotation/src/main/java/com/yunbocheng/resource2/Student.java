package com.yunbocheng.resource2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("myStudent")
public class Student {

    @Value("程云博")
    private String name;

    @Value("30")
    private Integer age;

    /*
    * 引用类型
    * @Resource ：来自jdk中的注解，spring框架提供了对这个注解功能支持，可以使用它给引用类型赋值
    *             使用的也是自动注入原理，支持byName、byType，默认是byName
    * 位置：1. 在属性定义的上面，无需set方法，推荐使用
    *      2. 在set方法上面
    *
    * @Resource只使用byName自动注入的方式。需要增加一个属性值 name
    * name的值是bean的id值
    * */

    // 默认是byName，如果使用byName失败，在使用byType。
    @Resource(name = "mySchool")
    private School school;

}
