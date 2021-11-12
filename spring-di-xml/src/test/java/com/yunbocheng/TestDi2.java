package com.yunbocheng;

import com.yunbocheng.di04.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDi2 {

    /*
    * 测试spring引用类型自动注入中的 byName
    * */
    @Test
    public void testByName(){
        String config = "di04/applicationContext.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ac.getBean("student");
        System.out.println(student);
    }

    /*
    * 测试spring引用类型自动注入中的 byType
    * */
    @Test
    public void testByType(){
        String config = "di04/applicationContext.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        com.yunbocheng.di05.Student student = (com.yunbocheng.di05.Student) ac.getBean("student1");
        System.out.println(student);
    }
}
