package com.sx.ThreadTest;

/**
 * 模拟电影院售票
 *
 */
public class Ticket_Test {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);

        t1.setName("售票平台1");
        t2.setName("售票平台2");
        t3.setName("售票平台3");

        t1.start();
        t2.start();
        t3.start();

    }
}

class Ticket implements Runnable{

    /**
     * 线程对象在使用共有变量时,
     * java会有优化会在线程内拷贝一份私有变量避免频繁调用公共变量
     * 但这样会导致同步问题
     * 使用volatile会禁用创建私有变量
     */
    private volatile int count = 100;
//    private volatile boolean flag = false;

    @Override
    public void run() {
        while (true){
            synchronized(this){
                if (count <= 0){
                    break;
                }else {
                    //售出一张做一次自减运算
                    count--;
                    try {
                        Thread.sleep((int)(Math.random()*100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+"卖出了1张,还剩"+count+"张");
            }
        }
    }
}
