package pers.yangzhen.classicexercises;

import java.util.Scanner;
public class PrimeNumber {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("输入范围：");
        int range = scan.nextInt();
        int count = 2;
        //System类中的currentTimeMillis方法返回从1970-01-01 00:00:00到现在的时间间隔（ms）
        long timeStart = System.currentTimeMillis();
        label:for(int i = 5;i <= range;i += 2){//从5开始，跳过2、3、4、以及其他偶数
            for(int j = 3;j <= Math.sqrt(i);j += 2){//由于跳过4，所以可以跳过对约数2的判断，从3开始
                //Math类中的sqrt方法返回参数的平方根
                if(i % j == 0){
                    continue label;//若为素数，则结束label处的本次循环
                }
            }
            //能执行到此处的肯定是素数
            //System.out.println(i);//打印该变量也会耗费一定的时间，
            count++;
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("改范围共有素数数量："+count);
        System.out.println("该程序所用时间：" + (timeEnd - timeStart) + "ms");


    }
}