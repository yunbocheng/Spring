package com.yunbocheng.before;


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
    * 定义方法，方法就是实现切面功能的。
    * 方法的定义要求：
    *   1. 公共方法public
    *   2. 方法中没有返回值
    *   3. 方法名称自定义
    *   4. 方法可以有参数，也可以没有参数。
    *      如果有参数，参数不是自定义的，有几个参数类型可以使用
    * */

    /*
    *   @Before : 前置通知注解
    *    属性：value，是切入点表达式，表示切面的功能执行的位置。
    *    位置：在切面类方法的上面
    *
    *  特点：
    *      1. 在目标方法之前先执行。
    *      2. 不会改变目标方法的执行结果。
    *      3. 不会影响目标方法的执行。
    * */
    /*
        注意：@Before声明这个方法执行的时间，
        value声明这个方法执行的位置。这个要指定切面代码要执行在哪个实体类中的哪个方法
            也就是声明要给哪个类中的哪个方法增加切面类中的方法。(给哪个类增加功能)
            这里的方法的参数只需给定类型即可，不需要给定形参值。
        使用这个value来指定谁是spring容器中的的目标类。
    */
    @Before(value = "execution(public void com.yunbocheng.before.SomeServiceImpl.doSome(String,Integer))")
    public void myBefore(){
        // 这就是切面所要执行的功能代码
        System.out.println("前置通知：切面功能：在目标方法之前输出执行时间：" + new Date());
    }

    /*
    * 一个目标类可以同时加入多个切面，我们这里给目标类添加两个切面，
    * 并且使用切入点表示的其他写法（通配符代替）
    * 此时任何包下的只要存在以do开头的方法，并且返回值可以是任意类型的、参数是任意的都可以加上这个切面。
    * */
    @Before(value = "execution(* *..SomeServiceImpl.do*(..))")
    public void myBefore2(){
        // 这就是切面所要执行的功能代码
        System.out.println("前置通知：切面功能：在目标方法之前输出执行时间：" + new Date());
    }

    /*给所有类中的所有以do开头的方法添加这个切面*/
    @Before(value = "execution(* do*(..))")
    public void myBefore3(){
        // 这就是切面所要执行的功能代码
        System.out.println("前置通知：切面功能：在目标方法之前输出执行时间：" + new Date());
    }

    /*给所有类中的所有的方法添加这个切面*/
    @Before(value = "execution(* *(..))")
    public void myBefore4(){
        // 这就是切面所要执行的功能代码
        System.out.println("前置通知：切面功能：在目标方法之前输出执行时间：" + new Date());
    }

    /*
    * 当给定的这个目标对象的方法与源类中的方法参数不匹配或方法名写错的时候
    * 此时程序不会报错，只是不能给目标对象加入这个切面功能。
    * */
    @Before(value = "execution(public void com.yunbocheng.before.SomeServiceImpl.doSome(String))")
    public void myBefore5(){
        // 这就是切面所要执行的功能代码
        System.out.println("前置通知：切面功能：在目标方法之前输出执行时间：" + new Date());
    }

    /*
    * 指定通知方法(切面方法myBefore6())中的参数，也就是这个切面中的这个方法 ： JoinPoint
    * 这个参数其实就是目标对象方法中给定的参数值，也就是doSome(String,Integer)中的参数值。
    *
    * JoinPoint : 目标对象中的业务方法(doSome(String,Integer))，也就是准备加入这个切面的目标对象中的方法
    *      作用是：可以在通知方法(切面方法myBefore6())中获取到目标对象方法(doSome(String,Integer))执行的信息。如：方法名称、方法的实参。
    *      如果切面功能需要使用目标方法中的参数信息，就使用JoinPoint获取
    *      这个JoinPoint参数的值是由框架赋予，必须是第一个位置的参数
    *
    * 这个JoinPoint不仅可以用在@Before注解中，可以用在任何的通知注解中。
    * */
    @Before(value = "execution(public void com.yunbocheng.before.SomeServiceImpl.doSome(String,Integer))")
    public void myBefore6(JoinPoint jp){
        // 获取目标对象中的方法(doSome(String,Integer)))的完整定义
        System.out.println("方法的签名(定义)：" + jp.getSignature());
        // 获取目标方法的名称
        System.out.println("方法的名称：" + jp.getSignature().getName());
        // 获取目标方法的实参，获取到的是一个目标方法实参的数组，这个数组中的实参值顺序就是方法中参数的顺序
        Object[] args = jp.getArgs();
        for (Object arg : args) {
            System.out.println("参数=" + arg);
        }
        // 这就是切面所要执行的功能代码
        System.out.println("前置通知：切面功能：在目标方法之前输出执行时间：" + new Date());
    }
}
