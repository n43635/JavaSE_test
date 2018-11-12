package com.sx.collection;

import java.util.ArrayList;

/**
 * 自定义的类是以引用的形式放入集合,当类中的属性被修改,所有引用的集合读取调用都是修改后的值
 */

//创建一个自定义类Car
class Car{

    //只有一个属性值i
    private int i;

    public Car(int i) {
        this.i = i;
    }

    public int getI() {

        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}

public class CustomClassInCollection {
    public static void main(String[] args) {

        //创建Car的实例
        Car car = new Car(1);

        //新建两个不同的ArrayList
        ArrayList<Car> arrayList1 = new ArrayList<>();
        ArrayList<Car> arrayList2 = new ArrayList<>();

        //将实例car加到两个ArrayList中去
        arrayList1.add(car);
        arrayList2.add(car);

        //修改第一个ArrayList中c对象,但不修改另一个ArrayList中的c对象
        arrayList1.get(0).setI(2);

        System.out.println(arrayList2.get(0).getI());//最终输出为2.另一个ArrayList中的c对象被修改了
        //这是因为ArrayList里添加的是引用

    }

}
