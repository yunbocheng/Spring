package com.yunbocheng;

import com.yunbocheng.before.SomeService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest01 {

    @Test
    public void Test01(){
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // 从容器中获取目标对象
        SomeService proxy = (SomeService) ac.getBean("someServiceImpl");
        System.out.println("proxy= " + proxy.getClass().getName());
        // 通过代理的对象执行方法，实现目标方法的执行，增强目标对象的功能
        proxy.doSome("程云博",20);
    }
}
