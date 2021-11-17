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

    // 声明两个dao的对象，为了是在service层调用dao层的方法
    private GoodsDao goodsDao;
    private SaleDao saleDao;

    // 声明这两个引用类型的set方法，
    // 因为要使用IoC的set注入的方式给这个两个引用变量赋值，可以使用注解的方式

    /*
        创建一个执行事务的方法，也就是买商品，当购买商品的时候要同时满足两个条件：
            1. 商品表中的数据要进行更改
            2. 订单表中要生成一条新的订单数据
        只有同时满足这两个条件，这个事务才算执行成功。才可以进行提交
        但凡有一条数据没有成功，那么就代表这个事务执行失败，抛出异常，回滚事务
    */
    /*
        添加事务注解
        注意：如果将事务的注解添加到方法之上，那么这个方法必须是public修饰的，否则无效
             如果是将事务的注解添加到类上，就代表这个类中的所有public方法都加入了事务。
    */
/*
    复杂写法：
    @Transactional(
            传播行为
            propagation = Propagation.REQUIRED,
            隔离级别
            isolation = Isolation.DEFAULT,
            是否是只读的
            readOnly = false,
            当方法中抛出什么异常的时候回滚
            rollbackFor = {
                    NullPointerException.class,RangeExceeds.class
            }
    )
       rollbackFor : 表示发生指定的异常一定回滚
        处理逻辑：
            1) spring框架首先会检查方法抛出的异常是不是在rollbackFor的异常类型列表中
               如果异常在rollbackFor列表中，不管是什么类型的异常，一定回滚。
            2) 如果方法抛出的异常不在你的rollbackFor异常类型列表中，spring会判断异常
               是不是运行时异常，如果是一定回滚。
    */
    /*
        因为我们此时使用的事务注解中的属性值都是默认值，所以此时注解写一个事务注解即可，不需要添属性值，
        默认的传播行为：REQUIRED 默认的隔离级别：DEFAULT 默认不是只读的
        默认抛出运行时异常，因为此时的NullPoint以及我们自己创建的异常(继承的RuntimeException)都是运行时异常，
        所以此时可以使用省略的模式。
    */
    @Transactional
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
