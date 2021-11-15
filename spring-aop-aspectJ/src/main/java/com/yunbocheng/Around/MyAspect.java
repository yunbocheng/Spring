package com.yunbocheng.Around;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Date;

/*
*  @Aspect 是aspectj中的一个注解
*   作用：表示当前类是切面类
*   切面类：是用来给业务方法增加功能的类，在这个类中有切面的功能代码
*   位置：在类定义的上面
* */

@Aspect
public class MyAspect {
    /*
    *  @Around ：环绕通知方法的定义格式
    *   1. public
    *   2. 必须有一个返回值，推荐使用Object
    *   3. 方法名称自定义
    *   4. 方法有参数，固定的参数 ProceedingJoinPoint
    *
    * */
    /*
    * @Around : 环绕通知
    *   属性：
    *       1. value : 切入点的位置
    *   位置 ：
    *       在方法体的上面
    *   特点：
    *       1. 它是功能最强的通知。
    *       2. 在目标方法的前和后都能增强功能。
    *       3. 控制目标方法是否被调用执行。注意是目标方法，不是切面中的通知方法
    *          也就是使用一些参数进行判断该方法执行不执行，并且这些参数大多数来自于目方法中的参数
    *       4. 修改原来的目标方法的执行结果。影响最后的调用效果。
    *
    *   环绕通知 = JDK的动态代理中的InvocationHandler接口
    *
    *   方法中的参数：
    *       ProceedingJoinPoint 就等同于jdk中的 Method
    *       作用：执行目标方法的。
    *   返回值：就是目标方法的返回值。可以被修改
    *
    *   环绕通知：经常做的是事务，在目标方法之前开启事务，执行目标方法，在目标方法之后提交事务。
    * */
    @Around(value = "execution(* *..SomeServiceImpl.doFirst(..))")
    public Object myAround(ProceedingJoinPoint point) throws Throwable {
        // 实现环绕通知的功能
        Object result = null;
        // 1. 在目标方法之前加入功能
        System.out.println("环绕通知：在目标方法之前，输出时间：" + new Date());

        // 2.目标方法调用
        result = point.proceed(); // method.invoke() ; Object result = doFirst();

        // 3. 在目标方法之后加入功能
        System.out.println("环绕通知：在目标方法之后，提交事务");


        // 4.返回目标方法的执行结果
        return result;
    }

    /*
    * 控制目标方法是否被执行调用
    *
    *   只有@Around注解声明的即环绕通知才存在目标方法是否被调用之说，
    *   因为只有在环绕声明中，他调用了 point.proceed(); 这个就代表调用目标方法
    *   而在其他的通知中，不会进行目标方法的调用
    *
    * 还需要注意的是：环绕通知调用的其实是通知方法，也就是说即使不调用目标方法，结果中也会显示环绕通知方法中结果
    *              而其他的通知方式调用的是目标对象中的方法，即使加不加切面功能，目标对象中的方法都可以执行。
    *               都会显示目标对象方法中的信息，至于显示不显示通知方法中的信息，得看你是否进行了功能的增强
    * */
    @Around(value = "execution(* *..SomeServiceImpl.doFirst1(..))")
    public Object myAround1(ProceedingJoinPoint joinPoint) throws Throwable {
        // 定义一个变量存储获取的目标对象参数
        String name = null;
        // 获取目标方法中的参数信息，判断是否执行目标方法
        Object[] args = joinPoint.getArgs();
        // 获取第一个参数，第一个参数传递的是姓名。还需判断这个集合是否为空，且长度大于1，防止报错，当存在参数值的时候在获取参数值
        if (args != null && args.length > 1){
            name = (String) args[0];
        }

        // 目标方法执行前的功能，获取当前时间
        System.out.println("环绕通知：目标方法执的时间：" + new Date());

        // 根据姓名判断是否要执行目标方法
        String  result = null;
        if ("张三".equals(name)){
            //此时匹配成功，执行目标对象的方法
            result = (String) joinPoint.proceed();
        }

        // 目标方法执行后，输出事务以及目标放的结果
        if (result == null){
            System.out.println("环绕通知：事务执行失败！");
        }else {
            // 修改输出结果
            result = "李四";
            System.out.println("环绕通知：事务执行成功！执行的结果为：" + result);
        }
        return result;
    }
}
