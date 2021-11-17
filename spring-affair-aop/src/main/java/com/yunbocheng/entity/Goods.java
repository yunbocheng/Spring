package com.yunbocheng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : YunboCheng
 * @date : 9:00 2021/11/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {

    // 商品编号
    private Integer id;

    // 商品名称
    private String name;

    // 商品数量
    private int amount;

    // 商品价格
    private int price;


}
