package com.yunbocheng.service.impl;

import com.yunbocheng.service.SomeService;

public class SomeServiceImpl implements SomeService {

    public SomeServiceImpl() {
        System.out.println("无参数构造方法！");
    }

    @Override
    public void doSome() {
        System.out.println("对象被创建了！！");
    }
}
