package com.sx.interface_jiekou;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * 测试default方法被重新定义后的状态
 */
public class AnotherTimeClientTest {
    public static void main(String[] args) {
        Method[] declaredMethods = AnotherTimeClient.class.getMethods();
        for (Method method:declaredMethods) {
            System.out.println(method.toString());
        }
    }

}