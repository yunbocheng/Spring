package com.yunbocheng.value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor

/*
* @Value ：简单类型的属性赋值
*  属性：value是String类型的，表示简单类型的属性值
*  位置：1. 在属性定义的上面，无需set方法，推荐使用。
*       2. 在set方法的桑上面。
* */
@Component("myStudent")
public class Student {

    @Value(value = "程云博") /*简单写法：@Value("程云博") */
    private String name;

    @Value(value = "20")  /*简单写法：@Value("20") */
    private Integer age;


}
