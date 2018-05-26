package com.sx.ThreadTest;

/**
 * 通过Thread类实现多线程
 *
 * 1自定义一个类,继承Thread类(java.lang包下的)
 * Override重写run方法
 * 将要在线程中执行的代码编写到run方法
 * 创建上面自定义类的对象
 * 调用start方法启动线程,不是run方法
 */

public class T_Test {
    public static void main(String[] args) {
        MyThread1 my1 = new MyThread1();
        MyThread2 my2 = new MyThread2();
        my1.start();
        my2.start();


        for (int i = 0; i < 100; i++) {
            System.out.println("main");
        }
    }

}
class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("MyThread1");
        }
    }
}
class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("MyThread2");
        }
    }
}
