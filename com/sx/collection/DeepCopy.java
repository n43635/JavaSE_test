package com.sx.collection;

import java.util.ArrayList;

/**
 * 如果要正确地实现“一个集合做备份另一个集合做修改”的效果，我们就得通过clone方法来实现深拷贝了
 *
 */

//实现Cloneable接口
class CarForDeepCopy implements Cloneable{
    private int i;

    public CarForDeepCopy(int i) {
        this.i = i;
    }

    public int getI() {

        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    //调用父类的clone完成对象的拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


public class DeepCopy {
    public static void main(String[] args) {

        CarForDeepCopy c1 = new CarForDeepCopy(1);

        //通过clone方法把c1备份到c2
        CarForDeepCopy c2 = null;
        try {
            c2 = (CarForDeepCopy) c1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        ArrayList<CarForDeepCopy> a1 = new ArrayList<>();
        ArrayList<CarForDeepCopy> a2 = new ArrayList<>();

        a1.add(c1);
        a2.add(c2);

        //修改a1中c对象的id为2
        a1.get(0).setI(2);

        System.out.println(a2.get(0).getI());//结果输出依然为1,并未受到另一个集合修改的影响
    }
}
