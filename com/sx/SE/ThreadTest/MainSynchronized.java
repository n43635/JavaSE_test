package com.sx.SE.ThreadTest;

/**
 * main方法使用Synchronized测试
 * main方法可以加同步代码
 */
public class MainSynchronized {
    public static synchronized void main(String[] args) {
        System.out.println("test!!");
    }
}