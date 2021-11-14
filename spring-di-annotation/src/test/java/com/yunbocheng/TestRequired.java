package com.yunbocheng;

import com.yunbocheng.autowried_required.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRequired {
    @Test
    public void testComponent(){
        String config = "spring-autowired-required.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student myStudent = (Student)ac.getBean("myStudent");
        System.out.println(myStudent);
    }
}
