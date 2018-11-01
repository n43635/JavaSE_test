package com.sx.ThreadTest.synchronized_test1;

/**
 * 三个同步方法类
 */

public class Synfun_UseSynfun {

    public synchronized void fun1(){
        System.out.println("我是第一个方法");
        this.fun2();//开启第二方法
    }

    public synchronized void fun2(){
        System.out.println("我是第二个方法");
        this.fun3();//开启第三方法
    }

    public synchronized void fun3(){
        System.out.println("我是第三个方法");
    }
}
