package com.yunbocheng;

import com.yunbocheng.resource.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestResource {
    @Test
    public void testComponent(){
        String config = "spring-resource.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student myStudent = (Student)ac.getBean("myStudent");
        System.out.println(myStudent);
    }
}
