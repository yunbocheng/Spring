package com.yunbocheng;

import com.yunbocheng.di06.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDi03 {


    /*测试包含关系的配置文件*/
    @Test
    public void test01(){
        /*这里需要使用主配置文件*/
        String config = "di06/spring-total.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ac.getBean("student");
        System.out.println(student);
    }


}
