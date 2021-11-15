package com.yunbocheng;

import com.yunbocheng.afterReturning.SomeService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAfterReturning {

    @Test
    public void testAfterReturning(){
        String config = "AfterReturning.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // 从容器中获取目标对象
        SomeService proxy = (SomeService) ac.getBean("someServiceImpl");
        System.out.println("proxy= " + proxy.getClass().getName());
        // 通过代理的对象执行方法，实现目标方法的执行，增强目标对象的功能
        proxy.doSome("程云博",20);
        proxy.doOther("李四",30);
    }
}
