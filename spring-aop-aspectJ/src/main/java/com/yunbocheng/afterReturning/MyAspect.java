package com.yunbocheng.afterReturning;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
    /*
    * @AfterReturning ：后置通知
    *   这个注解有两个属性：
    *       1.value : 切入点表达式
    *       2.returning : 自定义的变量，表示目标方法返回值的。
    *                     自定义变量名字必须与通知方法的形参名一致。
    *                     注意：这个属性是用来接收目标方法返回值的。而不是接收目标方法的参数的
    *                          所以使用一个接收返回值的参数即可，不需要多个参数。
    *                   相当于：Object res = doOther(String name, Integer age);
    *   位置：在方法定义的上面
    *
    *   特点：
    *       1. 在目标方法之后执行。
    *       2. 因为在目标方法之后执行，所以就可以接收目标方法的返回值、参数等信息。
    *          可以根据这个返回值做不同的处理功能。
    *       3. 我们可以修改返返回值。
    * */
    @AfterReturning(value = "execution(* *..SomeServiceImpl.doOther(..))",returning = "res")
    public void myAfterReturning(Object res){
        // Object res : 是目标方法执行后的返回值，根据返回值做其他的功能。
        System.out.println("后置通知：在目标方法之后执行的，获取的返回值是：" + res);
        if (res.equals("李四")){
            // 此时的业务
        }else {
            // 此时的业务
        }
    }

    @Before(value = "execution(* *..SomeServiceImpl.doSome(..))")
    public void myAfterReturning(JoinPoint point){
        System.out.println("前置通知：在目标方法之前执行的" );
        Object[] args = point.getArgs();
        for (Object arg : args) {
            System.out.println("获取的参数信息：" + arg);
        }
    }

    /*
    *
    * 注意：一定要将JoinPoint这个参数方法通知方法参数列表的第一位
    *
    * */
    @AfterReturning(value = "execution(* *..SomeServiceImpl.doOther(..))",returning = "res")
    public void myAfterReturning1(JoinPoint point,Object res){
        // Object res : 是目标方法执行后的返回值，根据返回值做其他的功能。
        System.out.println("后置通知：在目标方法之后执行的，获取的返回值是：" + res);
        Object[] args = point.getArgs();
        for (Object arg : args) {
            System.out.println("参数值：" + arg);
        }
        if (res.equals("李四")){
            // 此时的业务
        }else {
            // 此时的业务
        }
    }

}
