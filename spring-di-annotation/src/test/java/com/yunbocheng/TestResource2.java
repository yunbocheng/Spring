package com.yunbocheng;

import com.yunbocheng.resource2.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestResource2 {

    @Test
    public void testComponent(){
        String config = "spring-resource2.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student myStudent = (Student)ac.getBean("myStudent");
        System.out.println(myStudent);
    }
}
