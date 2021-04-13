package pers.yangzhen.array;


import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        //Arrays类中的常用方法
        //1.boolean equals(int[] a,int[] b)方法比较两数组是否相等（元素值是否相等）
        int[] array1 = new int[]{4,5,2,3};
        int[] array2 = new int[]{2,3,4,5};
        boolean isEqual = Arrays.equals(array1,array2);
        System.out.println(isEqual);

        //2.String toString(int[] a)方法输出数组信息
        System.out.println(Arrays.toString(array1));

        //3.void fill(int[] a,int val)方法将指定值填充到数组中
        Arrays.fill(array2,10);
        System.out.println(Arrays.toString(array2));

        //4.void sort(int[] a)方法对数组进行排序
        int[] array3 = new int[]{0, 12, -9, 123, 121, 90, 65, 1, 32, 19};
        Arrays.sort(array3);
        System.out.println(Arrays.toString(array3));

        //5.int binarySearch(int[] a,int key)方法查找数组中元素的索引
        int[] array4 = new int[]{0, 12, -9, 123, 121, 90, 65, 1, 32, 19};
        int index1 = Arrays.binarySearch(array3,121);
        int index2 = Arrays.binarySearch(array3,122);
        System.out.println(index1);
        System.out.println(index2);//若没有找到，则返回负数，具体是负多少，需查看该方法的源码

    }
}
