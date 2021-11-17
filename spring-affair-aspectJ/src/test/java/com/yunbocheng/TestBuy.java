package com.yunbocheng;

import com.yunbocheng.service.ServiceShop;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : YunboCheng
 * @date : 14:41 2021/11/17
 */
public class TestBuy {

    @Test
    public void testBuy(){
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        ServiceShop service = (ServiceShop) ac.getBean("studentService");
        // 输出对象的名字 ：service= com.sun.proxy.$Proxy16 此时代表的使用的spring中的aop动态代理模式。因为存在proxy
        System.out.println("service= " + service.getClass().getName());
        List<Object> list = new ArrayList<>();
        // 输出对象的名字：list= java.util.ArrayList  此时的格式代表没有使用代理模式
        System.out.println("list= " + list.getClass().getName());
        service.buy(2,5);
    }
}
