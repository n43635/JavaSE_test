package com.sx.SE.generic;

/**
 * <<java核心技术 第10版>>书上代码测试
 * 自定义泛型类
 * @Author Shixian
 * @Description
 * @Date 16:41 2019/3/22
 * @Param
 * @return
 **/
public class Pair<T> {

    private T first;
    private T second;

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(T first, T second) {

        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}
