package com.yunbocheng;

import com.yunbocheng.component.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestComponent {

    @Test
    public void testComponent(){
        String config = "spring-component.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student myStudent = (Student)ac.getBean("myStudent");
        System.out.println(myStudent);
    }
}
