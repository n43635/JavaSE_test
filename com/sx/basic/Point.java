package com.sx.basic;

/**
 * 定义一个点,点有xyz坐标
 *
 * 设计一个点的抽象类
 * 可以生成特定点的坐标对象
 * 可以提供设置三个坐标的方法
 * 提供两点距离平方和的方法
 */
public class Point {
    //点的三个坐标成员变量
    private double x;
    private double y;
    private double z;

    //构造方法
    private Point(double x,double y,double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //新点到原点平方和计算方法
    private double getDispoint(Point p){
        return (x - p.x)*(x - p.x)+(y - p.y)*(y - p.y)+(z - p.z)*(z - p.z);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public static void main(String[] Args){
        Point p1 = new Point(1.1, 2.1, 3.1);
        Point p2 = new Point(1.0, 2.0, 3.0);
        System.out.println(p1.getDispoint(p2));
        p1.setX(5.0);
        System.out.println(p1.getDispoint(new Point(1.0,1.0,1.0)));

    }
}
