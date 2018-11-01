package com.sx.ThreadTest.synchronized_test1;

public class SynThreadTest extends Thread {

    private Synfun_UseSynfun synfun_useSynfun;

    public SynThreadTest(Synfun_UseSynfun synfun_useSynfun) {
        this.synfun_useSynfun = synfun_useSynfun;
    }

    /**
     * 调用第一个同步方法
     */
    @Override
    public void run() {
        synfun_useSynfun.fun1();
    }
}
