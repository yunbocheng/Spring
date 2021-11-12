package com.yunbocheng;

import com.yunbocheng.di03.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.util.Date;

public class TestDi {

    /*
    * 给实体类中的属性赋值
    * */
    @Test
    public void test01() {
        String config = "di01/applicationContext.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ac.getBean("student");
        System.out.println(student);
    }

    /*
    * 给日期类中的时间赋值
    * */
    @Test
    public void test02(){
        String config = "di01/applicationContext.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Date date = (Date) ac.getBean("date");
        System.out.println(date);
    }

    /*
    * 给引用类型进行设值注入
    * */
    @Test
    public void test03(){
        String config = "di02/applicationContext.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        com.yunbocheng.di02.Student student = (com.yunbocheng.di02.Student)ac.getBean("student");
        System.out.println(student);
    }

    /*
    * 测试使用有参构造方法来赋值对象的参数值，使用School对象
    * */
    @Test
    public void test04(){
        String config = "di04/applicationContext.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        com.yunbocheng.di04.Student student = (com.yunbocheng.di04.Student)ac.getBean("student");
        System.out.println(student);
    }

    /*
    * 测试使用有参构造方法来赋值对象的参数值，使用index方式
    * */
    @Test
    public void test05(){
        String config = "di04/applicationContext.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ac.getBean("student");
        System.out.println(student);
    }

    /*
    * 测试获取File文件对象
    * */
    @Test
    public void test06(){
        String config = "di04/applicationContext.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        File file = (File) ac.getBean("myFile");
        /*可以获取到这个文件的路径信息，也就是这个为文件一个对象*/
        System.out.println(file);  // E:\word字体修改\字体修改(宏).txt
    }
}
