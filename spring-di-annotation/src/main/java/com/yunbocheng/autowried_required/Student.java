package com.yunbocheng.autowried_required;

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
    * 当@Qualifier注解中的id值书写错误的时候，此时会触发@Autowired注解中的一个属性值required
    *
    * required，是一个boolean类型的，默认是true
    * required == true ：表示引用类型赋值失败，程序报错，并且终止程序。
    * required == false ：表示引用类型赋值失败，程序正常执行，引用类型的赋值结果为null
    *
    * 在实际开发中我们设置为true，如果使用true就是默认值，可以省略不写。
    * */
    @Autowired(required = true)
    @Qualifier("mySchool")
    private School school;

}
