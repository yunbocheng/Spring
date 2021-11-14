package com.yunbocheng;

import com.yunbocheng.autowired.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutowired {

    @Test
    public void testComponent(){
        String config = "spring-autowired.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student myStudent = (Student)ac.getBean("myStudent");
        System.out.println(myStudent);
    }
}
