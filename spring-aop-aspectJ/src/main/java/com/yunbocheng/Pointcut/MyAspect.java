package com.yunbocheng.Pointcut;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Date;

/*
*  @Aspect 是aspectj中的一个注解
*   作用：表示当前类是切面类
*   切面类：是用来给业务方法增加功能的类，在这个类中有切面的功能代码
*   位置：在类定义的上面
* */

@Aspect
public class MyAspect {

    // 前置通知
    @Before(value = "cut()")
    public void myBefore(){
        System.out.println("前置通知：在目标方法执行之前执行！");
    }

    // 后置通知
    @AfterReturning(value = "cut()")
    public void myAfterReturning(){
        System.out.println("后置通知：在目标方法执行之后执行！");
    }

    /*
    * 此时上边的两个通知的目标对象的路径是一样的，也就是给同一个方法添加两个切面功能。
    * 此时使用 @Pointcut注解来减少代码的开发
    * @Pointcut ：用来定义和管理切面点。简化切入点的定义。
    *
    * @Pointcut : 定义和管理切入点，如果你的项目中有多个切入点表达式是重复的，可以服用的。
    *             可以使用 @Pointcut
    * 特点：
    *   当使用@Pointcut定义在一个方法的上面，此时这个方法的名称就是切入点表达式的别名。
    *   其他的通知中，value属性值就可以使用这个方法的名称代替切入点表达式。
    *
    * 提示：
    *   一般将这个方法声明为private类型，防止其他类继承或者修改，且其中不含有方法体代码。
    * */
    @Pointcut(value = "execution(* *..SomeServiceImpl.doSome(..))")
    private void cut(){
        // 这个方法不需要提供方法，只是为了减少execution的开发。
    }
}
