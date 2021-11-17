package com.yunbocheng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author : YunboCheng
 * @date : 21:59 2021/11/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    // 属性名和数据库的列名一致
    private String num;

    private String province;

    private String city;

    private String name;

    private Integer age;

    private Double score;

    private String room;

}
