package com.yunbocheng;

import com.yunbocheng.entity.Student;
import com.yunbocheng.service.StudentService;
import com.yunbocheng.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author : YunboCheng
 * @date : 17:03 2021/11/16
 */
public class TestServiceSelectAll {

    @Test
    public void testSelectAllStudent(){
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // 此时使用的是 StudentService 对象中的方法，需要给定 StudentService的id值，通过StudentService中的方法调用dao层的方法
        // 此时的返回值使用 StudentService 或者 StudentServiceImpl 接收都可以，因为他是这个接口的一个实现类，使用接口或者接口的实现类接收返回值结果都可以
        StudentService service = (StudentServiceImpl) ac.getBean("studentService");
        System.out.println(service); // com.yunbocheng.service.impl.StudentServiceImpl@4a7f959b
        List<Student> list = service.queryStudents();
        /*
        * 注意：使用是spring整合mybatis的时候事务是自动提交的，不需要在 sqlSession.commit();
        *      我们以前单独使用mybatis的时候，默认是不会自动提交的，除非我们在创建sqlSession的时候给定参数为true才会自动提交
        *      sqlSession = factory.openSession(true); // 自定提交
        * */
        for (Student student : list) {
            System.out.println(student);
        }
    }

}
