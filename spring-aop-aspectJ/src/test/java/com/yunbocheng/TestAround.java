package com.yunbocheng;


import com.yunbocheng.Around.SomeService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAround {

    @Test
    public void testAround(){
        String config = "Around.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        SomeService proxy = (SomeService) ac.getBean("someServiceImpl");
        // 在这里看是在执行doFirst()方法，其实是在执行myAround()方法，在myAround()方法中嵌套执行doFirst()方法
        proxy.doFirst("张三",50);
    }

    @Test
    public void testAround1(){
        String config = "Around.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        SomeService proxy = (SomeService) ac.getBean("someServiceImpl");
        // 在这里看是在执行doFirst()方法，其实是在执行myAround()方法，在myAround()方法中嵌套执行doFirst()方法
        String name = proxy.doFirst1("张三", 50);
        System.out.println(name);
    }
}
