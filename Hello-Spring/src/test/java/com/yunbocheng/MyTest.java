package com.yunbocheng;

import com.yunbocheng.service.SomeService;
import com.yunbocheng.service.impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {

    // 使用普通方式创建实体类对象(正转)
    @Test
    public void test01(){
        /*正转*/
        SomeService service = new SomeServiceImpl();
        service.doSome();
    }

    // 使用spring的控制反转来创建实体类对象

    /*
    * spring默认创建对象的时间：在创建spring的容器时，会创建配置文件的所有的对象。
    * */
    @Test
    public void test02(){
        // 使用spring容器创建对象
        // 1. 指定spring配置文件的名称
        String config = "applicationContext.xml";
        // 2. 创建表示spring容器的对象，ApplicationContext
        // ApplicationContext就是表示spring容器，通过容器就可以获取对象了。
        // ClassPathXmlApplicationContext()表示从类路径中加载spring的配置文件。
        // 这个类路径还是target/classes路径
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        // 从容器中获取某个对象，你要调用对象的方法
        // getBean("配置文件下bean的id值")，这个方法的返回值类型是Object，需要进行类的类型转换。
        // 这来转换为someService接口类型，因为要调用someService中的方法
        // service就是这个接口的实体对象
        SomeService service = (SomeService) ac.getBean("someService");

        // 因为spring容器为我们创建出来了接口的实现类，我们直接使用接口调用方法
        service.doSome();

    }

    /**
     * 获取spring容器中Java对象的信息
     */
    @Test
    public void test03(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // 使用spring提供的方法，获取容器中定义的对象的数量
        int num = ac.getBeanDefinitionCount();
        System.out.println(num);

        // 容器中每个定义对象的名称
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    /*
    * 测试不是自定义的类是Java创建好的类 使用spring容器来获取对象
    *
    * */
    @Test
    public void test04(){
        // 获取sprig的配置文件
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // ac就是spring 的一个容器 ，使用这个容器来创建对象
        Date date = (Date) ac.getBean("date");
        System.out.println(date);
    }
}
