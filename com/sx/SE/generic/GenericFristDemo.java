package com.sx.SE.generic;

/**
 * <<java核心技术 第10版>>书上代码测试
 * 泛型第一个测试类
 * 关联自定义测试类Pair
 *
 * @Author Shixian
 * @Description
 * @Date 16:43 2019/3/22
 * @Param
 * @return
 **/
public class GenericFristDemo {
    public static void main(String[] args) {
        String[] words = {"my","name","is","SX"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min:"+mm.getFirst());
        System.out.println("max:"+mm.getSecond());
    }

    private static class ArrayAlg {
        public static Pair<String> minmax(String[] awords) {
            if (awords == null || awords.length == 0){
                return null;
            }
            String min = awords[0];
            String max = awords[0];
            for (int i = 1; i < awords.length; i++) {
                if (min.compareTo(awords[i])>0)
                    min = awords[i];
                if (max.compareTo(awords[i])<0)
                    max = awords[i];
            }
            return new Pair<>(min,max);
        }
    }
}
