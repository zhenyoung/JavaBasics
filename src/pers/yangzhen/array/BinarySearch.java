package pers.yangzhen.array;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        //二分法查在数组中查找是否有给定的值
        int[] array = new int[]{-18, -9, 12, 21, 34, 45, 78, 90, 99, 123};
        int head = 0;
        int end = array.length - 1;

        System.out.print("请输入需要查找的值：");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        boolean flag = true;
        while (head < end) {
            int middle = (head + end) / 2;
            if (number == array[middle]) {
                System.out.print("找到了指定的元素，索引位置为：" + middle);
                flag = false;
                break;
            } else if (number > array[middle]) {
                head = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        if (flag) {
            System.out.println("很遗憾，没有找到该元素值");
        }
    }
}
