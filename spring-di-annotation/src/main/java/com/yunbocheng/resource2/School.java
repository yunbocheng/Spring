package com.yunbocheng.resource2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("mySchool")
public class School {

    @Value("清华大学")
    private String Address;

    @Value("北京")
    private String name;

}
