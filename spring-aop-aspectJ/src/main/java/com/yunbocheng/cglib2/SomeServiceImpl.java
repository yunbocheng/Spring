package com.yunbocheng.cglib2;


// 这个类就是目标类，需要增加功能的类
// 当目标类存在接口的时候，仍想使用 cglib 代理的方式，此时需要在spring的配置文件中的声明自动代理生成器中添加属性
public class SomeServiceImpl implements SomeService {

    @Override
    public void doSome(String name, Integer age) {

        System.out.println("======目标方法doSome()==========");
    }

}
