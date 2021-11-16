package com.yunbocheng;

import com.yunbocheng.dao.StudentDao;
import com.yunbocheng.entity.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author : YunboCheng
 * @date : 11:52 2021/11/16
 */
public class TestSelectAll {

    @Test
    public void testSelectAllStudent(){
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext sc = new ClassPathXmlApplicationContext(config);
        StudentDao dao = (StudentDao) sc.getBean("studentDao");
        List<Student> list = dao.selectStudents();
        for (Student student : list) {
            System.out.println(student);
        }
    }
}
