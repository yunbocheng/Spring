package com.yunbocheng.cglib;


// 这个类就是目标类，需要增加功能的类
// 此时目标类没有实现接口，此时使spring自定使用的是 cglib来实现的aop动态代理
public class SomeServiceImpl {

    public void doSome(String name, Integer age) {

        System.out.println("======目标方法doSome()==========");
    }
}
