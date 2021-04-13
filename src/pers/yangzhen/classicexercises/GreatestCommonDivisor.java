package pers.yangzhen.classicexercises;

import java.util.Scanner;
public class GreatestCommonDivisor {
    public static void main(String[] args){
        //核心思想：欧几里德算法或者stein算法
        Scanner scan = new Scanner(System.in);
        System.out.println("输入两个数：");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int temp1 = num1;
        int temp2 = num2;//尽量不修改输入的值及顺序
        if(temp1 < temp2){
            int temp = temp1;
            temp1 = temp2;
            temp2 = temp;
        }
        /*欧几里得算法*/
        while(temp1 % temp2 != 0){
            int temp = temp2;
            temp2 = temp1 % temp2;
            temp1 = temp2;
        }
        int greatestCommonDivisor = temp2;
        System.out.println("最大公约数："+greatestCommonDivisor);
        System.out.println("最小公倍数："+(num1*num2/greatestCommonDivisor));
    }
}