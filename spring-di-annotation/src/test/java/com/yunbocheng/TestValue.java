package com.yunbocheng;

import com.yunbocheng.value.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestValue {
    @Test
    public void testComponent(){
        String config = "spring-value.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student myStudent = (Student)ac.getBean("myStudent");
        System.out.println(myStudent);
    }
}
