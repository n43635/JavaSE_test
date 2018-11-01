package com.sx.ThreadTest.synchronized_test1;

public class mainTest {

    public static void main(String[] args) {
        Synfun_UseSynfun synfun_useSynfun = new Synfun_UseSynfun();
        SynThreadTest synThreadTest = new SynThreadTest(synfun_useSynfun);
        synThreadTest.run();
    }
}
