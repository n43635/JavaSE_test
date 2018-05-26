package com.sx.ThreadTest;

/**
 * 使用lambda表达式创建线程
 * ()->{这里相当于重写run方法}
 *
 */

public class Lambda_Test {

    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            System.out.println("使用lambda表达式创建1");
        });
        Thread t2 = new Thread(()->{
            System.out.println("使用lambda表达式创建2");
        });

        t1.start();
        t2.start();
    }
}
