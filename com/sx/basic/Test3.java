package com.sx.basic;

public class Test3 {
    public static void main(String[] args) {
        switch(2){
            case 1:
                System.out.println("Test1");
                break;
            case 2:
            case 3:
                System.out.println("Test2");
                break;
            default:
                System.out.println("end");
        }
    }
}
