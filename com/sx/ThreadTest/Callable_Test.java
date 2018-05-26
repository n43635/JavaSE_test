package com.sx.ThreadTest;

/**
 * 实现Callable接口,该接口在java.util.concurrent包下
 *   可以有返回值
 *   可以声明异常
 * 1自定义一个类,继承Callable类(java.util.concurrent包下)
 * 2重写call()方法
 * 3将要在线程中执行的代码编写在call方法中
 * 4创建ExecutorService线程池
 * 5将自定义类的对象放到线程池中
 * 6获取线程的返回结果
 * 7关闭线程池,不再接受新的线程,未执行完的线程不会被关闭
 *
 */

import java.util.concurrent.*;

public class Callable_Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //创建线程池
        ExecutorService es = Executors.newCachedThreadPool();

        //向线程池添加自定义类对象
        Future<Integer> f1 = es.submit(new MyCallable(3));
        Future<Integer> f2 = es.submit(new MyCallable(5));

        //获取线程返回结果
        System.out.println("3的阶乘结果为:"+f1.get());
        System.out.println("5的阶乘结果为:"+f2.get());

        //关闭线程池
        es.shutdown();
    }
}

class MyCallable implements Callable<Integer>{

    private int count;

    public MyCallable(int count) {
        this.count = count;
    }


    //实现一个阶乘计算
    @Override
    public Integer call() throws Exception {

        int sun = 1;

        if(count == 0){
            sun = 0;
        }else {
            for (int i = 1; i < count; i++) {
                sun *= count;
            }
        }

        //打印当前线程名
//        System.out.println(Thread.currentThread().getName());

        return sun;
    }
}
