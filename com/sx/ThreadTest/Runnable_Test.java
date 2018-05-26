package com.sx.ThreadTest;

/**
 * 通过Runnable接口实现
 * 1自定义一个类,继承Runnable类(java.lang包下的)
 * 2@Override重写run方法
 * 3将要在线程中执行的代码,编写到run方法
 * 4创建上面自定义类的对象
 * 5调用start方法启动线程,不是run方法
 */

public class Runnable_Test {
    public static void main(String[] args) {
        MyRunnable1 mr = new MyRunnable1();
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);
        t1.start();
        t2.start();
    }
}

class MyRunnable1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName()+"  MyRunnable1  "+i);
        }
    }
}