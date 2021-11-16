package com.yunbocheng;

import com.yunbocheng.dao.StudentDao;
import com.yunbocheng.entity.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : YunboCheng
 * @date : 15:11 2021/11/16
 */
public class TestSelectByNumAndRoom {

    @Test
    public void testSelectByNumAndRoom(){
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        StudentDao dao = (StudentDao) ac.getBean("studentDao");
        Student student = dao.selectByNumAndRoom("110522", "Java1004");
        System.out.println(student.toString());
    }
}
