package com.yunbocheng;

import com.yunbocheng.dao.StudentDao;
import com.yunbocheng.entity.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.crypto.spec.PSource;
import javax.swing.plaf.PanelUI;

/**
 * @author : YunboCheng
 * @date : 11:25 2021/11/16
 */
public class TestInsert {

    @Test
    public void testInsertStudent(){
        // 声明spring主配置文件的位置，因为要从spring容器中获取到sqlSession对象
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // 这些dao接口在spring的主配置文件中进行了调用getMapper()方法，获取到了对应的dao对象。
        // 且dao对象的名称是接口名的首字母小写。
        // 以前在mybatis中调用 StudentDao dao = sqlSession.getMapper(StudentDao.class);
        // 此时dao接口的实现类的名字是自定义的。
        // 这段代码是获取spring容器中的dao对象，以前是通过id获取dao对象的
        StudentDao dao = (StudentDao) ac.getBean("studentDao");
        System.out.println("StudentDao对象：" + dao);

        // 创建一个学生对象并赋值
        Student student = new Student();
        student.setNum("110522");
        student.setName("程云博");
        student.setAge(20);
        student.setCity("承德市");
        student.setProvince("河北省");
        student.setRoom("Java1105");
        student.setScore(89.9);

        // 使用这个dao对象调用其中的方法，将数据插入到数据库中
        int i = dao.insertStudent(student);
        if (i == 1){
            System.out.println("添加成功！");
        }else {
            System.out.println("添加失败！");
        }
    }
}

