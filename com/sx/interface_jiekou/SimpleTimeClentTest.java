package com.sx.interface_jiekou;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 测试实现方法的调用
 */
public class SimpleTimeClentTest {

    @Test
    public static void main(String[] args) {
        SimpleTimeClent simpleTimeClent = new SimpleTimeClent();
        System.out.println(simpleTimeClent.toString());

        //可以测试default方法在实现类中是否可以使用
        System.out.println(simpleTimeClent.getZonedDateTime("test"));
    }

}