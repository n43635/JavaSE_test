package com.sx.array;

import java.util.Arrays;
import java.util.Random;

/**
 * 双色球生成,使用数组不使用集合
 */
public class DoubleColorBalls {

    //从数值库中随机生成指定长度数组,传入生成随机数位数和随机数范围最大值
    public static int[] resultRandomNum(int ballNum, int maxNum){

        //生成随机数保存
        int[] resultNum = new int[ballNum];

        //用于判断索引对应数值是否使用过
        boolean[] isUsed = new boolean[maxNum];
        Random random = new Random();

        //生成随机数数组索引
        int resultNumIndex = 0;

        //生成的随机数
        int randomNum;

        while (true){
            if (resultNumIndex > 5){
                break;
            }

            //nextIndex(num)是0到num(不包括num)之间随机一个整数
            //生成0-32(传入最大值)之间随机数
            randomNum = random.nextInt(maxNum);
            if (isUsed[randomNum] == true) {
                continue;
            }
            //由于生成的随机数是0-32(传入最大值之间),结果需要+1
            resultNum[resultNumIndex++] = randomNum +1;
            isUsed[randomNum] = true;
        }
        Arrays.sort(resultNum);
        return resultNum;
    }

    public static void main(String[] args) {
        int[] redNum = resultRandomNum(6, 33);

        //蓝球生成,生成的结果是0-15之间,需要将结果+1
        int blueNum = new Random().nextInt(16)+1;

        //打印红球
        System.out.print("红球:");
        for (int i = 0; i < redNum.length; i++) {
            if (redNum[i] < 10){
                System.out.print("0"+redNum[i]+"  ");
            }else {
                System.out.print(redNum[i] + "  ");
            }
        }

        //打印蓝球
        System.out.println("\n蓝球:"+blueNum);
    }
}
