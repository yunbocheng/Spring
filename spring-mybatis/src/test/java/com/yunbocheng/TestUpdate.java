package com.yunbocheng;

import com.yunbocheng.dao.StudentDao;
import com.yunbocheng.entity.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : YunboCheng
 * @date : 14:10 2021/11/16
 */

public class TestUpdate {

    @Test
    public void testUpdateStudent(){
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        StudentDao dao = (StudentDao) ac.getBean("studentDao");
        Student student = new Student();
        student.setAge(80);
        student.setRoom("Java1103");
        student.setScore(100.0);
        student.setNum("110520");
        int i = dao.updateStudent(student);
        if (i == 1){
            System.out.println("修改成功！");
        }else {
            System.out.println("修改失败！");
        }
    }
}
