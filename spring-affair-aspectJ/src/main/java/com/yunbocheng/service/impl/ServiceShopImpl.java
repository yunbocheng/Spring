package com.yunbocheng.service.impl;

import com.yunbocheng.dao.GoodsDao;
import com.yunbocheng.dao.SaleDao;
import com.yunbocheng.entity.Goods;
import com.yunbocheng.entity.Sale;
import com.yunbocheng.error.RangeExceeds;
import com.yunbocheng.service.ServiceShop;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : YunboCheng
 * @date : 9:21 2021/11/17
 */
@Setter
public class ServiceShopImpl implements ServiceShop {

    // 此处多声明几个方法，目的是测试使用方法的通配符模式
    public void addSale(){};
    public void addGoods(){};

    public void modifyGoods(){};
    public void modifySale(){};

    // 声明两个dao的对象，为了是在service层调用dao层的方法
    private GoodsDao goodsDao;
    private SaleDao saleDao;

    @Override
    public void buy(Integer id, int nums){
        System.err.println("======开始执行buy方法======");

        // 执行生成订单的方法
        Sale sale = new Sale();
        sale.setGid(id);
        sale.setNums(nums);
        int i = saleDao.insertSale(sale);
        if (i == 1){
            System.err.println("订单数据生成成功！");
        }else{
            System.err.println("订单数据生成失败！");
        }

        // 判断用户购买的商品以及商品数量是否合法（商品书否存在以及购买数量是否大于库存）
        // 调用根据id值查询数据库产品的方法，如果返回值我不为null说明这个商品存在，如果为null，说明不存在
        Goods goods = goodsDao.selectGoods(id);
        if (goods == null){
            // 说明此时数据库中不存在这件商品，抛出空指针异常
            throw  new NullPointerException("商品编号为" + id + "的商品不存在！");
        }else if (goods.getAmount() < nums){
            //可以进入到else if 说明此时的商品是存在的，此时抛出的这个异常在JDK中不存在，是我们自定义的。
            throw new RangeExceeds("购买"+ goods.getName()+" 的数量超过了库存的数量!");
        }

        // 如果没有抛出异常，此时更新仓库的商品信息
        Goods newGoods = new Goods();
        newGoods.setAmount(goods.getAmount() - nums);
        newGoods.setId(id);
        int k = goodsDao.updateGoods(newGoods);
        if (k == 1){
            System.err.println("库存信息修改成功！");
        }else {
            System.err.println("库存修改失败！");
        }

        System.err.println("======结束执行buy方法======");
    }
}
