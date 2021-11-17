package com.yunbocheng.error;

/**
 * @author : YunboCheng
 * @date : 11:38 2021/11/17
 */

/*
* 这是我们自定义的一个异常类，也就是JDK中不存在的异常类，
* 像空指针异常、数组下标越界异常等在JDK中都存在，我们直接new 这个已经存在的异常类即可，
* 就可以抛出这个异常类中已经在JDK中写好的异常信息。
*
* 但是当我们想要的异常类在JDK中不存在的时候，这个时候就需要我们手动创建一个异常类并给出异常信息
* 这样在我们调用方法的时候就可以根据判断抛出这个自定义异常类的异常信息。
*
* 我们书写的是一个运行时异常的类，所以要集成运行时异常的父类。获取继承更的的异常父类 Throwable 都可以
*
* 之后继承这个异常类的无参以及有参构造方法 可以子=在new这个异常类对象的时候创异常信息，然后抛出
*
* */
public class RangeExceeds extends RuntimeException{

    public RangeExceeds() {
        super();
    }

    public RangeExceeds(String message) {
        super(message);
    }
}
