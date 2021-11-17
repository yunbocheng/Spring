package com.yunbocheng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : YunboCheng
 * @date : 9:01 2021/11/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {

    // 订单编号
    private Integer id;

    // 商品编号
    private Integer gid;

    // 商品数量
    private int nums;


}
