package com.yunbocheng.cglib;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

/*
*  @Aspect 是aspectj中的一个注解
*   作用：表示当前类是切面类
*   切面类：是用来给业务方法增加功能的类，在这个类中有切面的功能代码
*   位置：在类定义的上面
* */

@Aspect
public class MyAspect {
    @Before(value = "execution(* *..SomeServiceImpl.doSome(..))")
    public void myAfterReturning(){
        System.out.println("前置通知：在目标方法之前执行的" );
    }
}
