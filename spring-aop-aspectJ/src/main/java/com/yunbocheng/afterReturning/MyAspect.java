package com.yunbocheng.afterReturning;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

/*
*
* 这个类就是切面类，其切面的功能在类的方法中实现。
*
*  @Aspect ：是aspectJ框架中的注解。
*       作用：表示当前类是切面类
*       切面类：是用来给业务方法增加功能的类，在这个类中有切面的功能代码
*       位置：在类定义的上面
* */
@Aspect
public class MyAspect {

    /*
    * 后置通知定义方法，方法就是实现切面功能的。
    * 方法的定义要求：
    *   1. 公共方法public
    *   2. 方法中没有返回值
    *   3. 方法名称自定义
    *   4. 方法必须有参数，推荐使用Object，参数名自定义。
    *
    * */
    public void myAfterReturning(Object res){

    }

}
