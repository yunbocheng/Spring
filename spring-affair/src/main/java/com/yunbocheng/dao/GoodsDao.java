package com.yunbocheng.dao;

import com.yunbocheng.entity.Goods;

import java.util.List;

/**
 * @author : YunboCheng
 * @date : 9:19 2021/11/17
 */
public interface GoodsDao {

    // 定义一个更新库存的方法
    int updateGoods(Goods goods);

    // 定义一个查询仓库的方法。这个方法是为了判断数据库中有没有这个商品
    Goods selectGoods(Integer id);

}
