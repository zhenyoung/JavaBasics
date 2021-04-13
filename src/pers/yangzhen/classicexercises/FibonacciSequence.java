package pers.yangzhen.classicexercises;

import java.util.Scanner;

public class FibonacciSequence {
    /* 需求：
    * 输入一个数据n，计算斐波那契数列（Fibonacci）的第n个值，并将整个数列打印出来，如
    * 1 1 2 3 5 8 13 21 34 55...
    * 注：斐波那契数列的规律为：一个属等于前两个数之和
    *
    * */
    public static void main(String[] args) {
        int[] arr = new int[100];
        System.out.print("n = ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        FibonacciSequence test = new FibonacciSequence();
        //前n项斐波那契数列存到数组arr中
        for(int i = 1;i <= n;i++){
            arr[i] = test.function(arr,i);
        }
        System.out.println("前" + n + "项斐波那契数列如下：");
        for(int i = 1;i <= n;i++){
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
    /*利用递归，创建方法求出斐波那契数列的某一项的值*/
    public int function (int[] arr,int n){
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 1;
        }else{
            return arr[n-1] + arr[n-2];
        }
    }

}
