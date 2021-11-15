package com.yunbocheng;

import com.yunbocheng.cglib2.SomeService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCglib2 {

    @Test
    public void testCglib2(){
        String config = "cglib2.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        SomeService proxy = (SomeService) ac.getBean("someServiceImpl");
        System.out.println(proxy);  // com.yunbocheng.cglib2.SomeServiceImpl@9d5509a cglib代理
        proxy.doSome("李四",20);
    }
}
