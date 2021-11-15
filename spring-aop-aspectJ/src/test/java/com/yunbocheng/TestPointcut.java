package com.yunbocheng;

import com.yunbocheng.Pointcut.SomeService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPointcut {

    @Test
    public void testPointcut(){
        String config = "Pointcut.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        SomeService proxy = (SomeService) ac.getBean("someServiceImpl");
        System.out.println(proxy);  // com.yunbocheng.Pointcut.SomeServiceImpl@1ab3a8c8 jdk动态代理
        proxy.doSome("李四",20);
    }
}
