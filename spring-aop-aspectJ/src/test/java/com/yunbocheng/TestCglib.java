package com.yunbocheng;

import com.yunbocheng.cglib.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
* 此时使用的是 cglib方法
* */
public class TestCglib {

    @Test
    public void testCglib(){
        String config  = "cglib.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        SomeServiceImpl proxy = (SomeServiceImpl) ac.getBean("someServiceImpl");
        proxy.doSome("程云博",20);
    }
}
