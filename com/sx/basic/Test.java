package com.sx.basic;

class Value{
    public int i = 15;
}

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.frist();
    }

    public void frist(){
        int i = 5;
        Value value = new Value();
        value.i = 25;
        second(value, i);
        System.out.println(value.i+"&"+i+"\r\n");
    }

    public void second(Value v,int i){
        i = 0;
        v.i = 20;
        Value val = new Value();
        v=val;
        System.out.println(v.i+"&"+i+"\r\n");
    }
}
