package com.yunbocheng.before;


// 这个类就是目标类，需要增加功能的类
public class SomeServiceImpl implements SomeService{

    @Override
    public void doSome(String name, Integer age) {

        // 给doSome增加一个功能，在doSome()之前执行，输出方法的执行时间。非业务功能
        // 这个是要执行的业务代码
        System.out.println("======目标方法doSome()==========");
    }
}
