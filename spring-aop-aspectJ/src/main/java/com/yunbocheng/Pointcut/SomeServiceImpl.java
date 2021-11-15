package com.yunbocheng.Pointcut;


// 这个类就是目标类，需要增加功能的类
public class SomeServiceImpl implements SomeService {

    @Override
    public void doSome(String name, Integer age) {

        System.out.println("======目标方法doSome()==========");
    }

}
