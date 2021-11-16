package com.yunbocheng;

import com.yunbocheng.dao.StudentDao;
import com.yunbocheng.entity.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author : YunboCheng
 * @date : 12:08 2021/11/16
 */
public class TestDeleteStudent {

    @Test
    public void testDeleteStudent(){
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext sc = new ClassPathXmlApplicationContext(config);
        StudentDao dao = (StudentDao) sc.getBean("studentDao");
        int i = dao.deleteStudent("110522");
        if (i == 1){
            System.out.println("删除成功！");
        }else {
            System.out.println("删除失败！");
        }
    }
}
