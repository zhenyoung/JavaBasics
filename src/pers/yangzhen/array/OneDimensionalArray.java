package pers.yangzhen.array;

import java.util.Scanner;

public class OneDimensionalArray {
    public static void main(String[] args) {
        //1.数组静态初始化
        int[] array1_1 = new int[]{1, 2, 3, 4};//引用类型初始化都需要借助new
        String[] array1_2 = new String[]{"川建国", "拜振华", "FakeNews", "China"};

        //2.数组动态初始化
        int[] array2_1 = new int[4];
        String[] array2_2 = new String[4];

        System.out.println(array2_1.length);//length属性返回数组的长度
        //数组一旦初始化，便确定了长度


        //要求：输入学生人数及分数，根据分数与最高分之间的差值来评级：[0,10)为A，[10,20)为B，[20,30)为C，[30,maxScore]为D
        System.out.println("输入人数：");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int[] score = new int[number];
        int maxScore = score[0];
        System.out.println("输入分数：");
        for (int index = 0; index < score.length; index++) {
            score[index] = scan.nextInt();
            if (maxScore < score[index]) {
                maxScore = score[index];
            }
        }
        System.out.println("最高分maxScore = " + maxScore);
        for (int index = 0; index < score.length; index++) {
            if (maxScore - score[index] < 10) {
                System.out.println("学生" + index + "的分数等级为：" + "A");
            } else if (maxScore - score[index] < 20) {
                System.out.println("学生" + index + "的分数等级为：" + "B");
            } else if (maxScore - score[index] < 30) {
                System.out.println("学生" + index + "的分数等级为：" + "C");
            } else if (maxScore - score[index] <= maxScore) {
                System.out.println("学生" + index + "的分数等级为：" + "D");
            }
        }


    }
}