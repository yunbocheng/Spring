package com.yunbocheng.dao;

import com.yunbocheng.entity.Sale;

/**
 * @author : YunboCheng
 * @date : 9:19 2021/11/17
 */
public interface SaleDao {

    // 定义一个生成订单的方法
    int insertSale(Sale sale);
}
