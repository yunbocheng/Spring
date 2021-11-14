package com.yunbocheng.autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
    * @Autowired : spring框架提供的注解，实现引用类型的赋值。
    * spring中通过注解给引用类型赋值，使用的是自动注入原理，支持byName、byType
    *
    * @Autowired：默认使用的是byType自动注入的方式。
    *
    * 位置：1. 在引用属性的上面，无需set方法，推荐使用。
    *      2. 在set方法的上面。
    *
    * @Autowired ：使用byName的方式完成自动注入，需要做的是：
    *   1. 在属性的上面加入@Autowired
    *   2. 在属性上面加入@Qualifier(value="bean的id值") : 表示使用指定名称的bean完成赋值。
    *
    *
    * 使用byType的时候需要一个注解：@Autowired
    * 使用byName的时候需要两个注解：@Autowired、@Qualifier
     * */

    /*这两个注解没有先后顺序，哪个在前哪个在后都可以*/
    @Autowired
    @Qualifier(value = "mySchool")
    private School school;

}
