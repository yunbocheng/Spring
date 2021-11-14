package com.yunbocheng.autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor

// @Component("mySchool") 我们这里不使用注解的方式来创建学校对象
// 采用注解与配置文件结合的方式创建对象，此时这个类里面的@value注解中的值会失效
// 此时的属性值由xml配置文件中property标签赋值。我们使用注解+xml配置文件的方式实现。

// 如果同时使用注解和xml的方式来创建对象，会以xml文件中赋的属性值为准。我们这里还是使用注解的方式，将xml中的配置注释掉。
@Component("mySchool")
public class School {

    @Value("北京大学")
    private String Address;

    @Value("北京")
    private String name;

}
