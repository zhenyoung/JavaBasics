package pers.yangzhen.array;

public class TwoDimensionalArray {

    public static void main(String[] args) {
        //1.静态初始化
        int[][] array1 = new int[][]{{1, 2, 3}, {4, 5, 6}};

        //2.动态初始化
        int[][] array2_1 = new int[2][3];
        int[][] array2_2 = new int[2][];

        int[][] arr = new int[4][3];
        System.out.println(arr);//[[I@1b6d3586，“[[”代表二维数组，“I”代表int型，@后面的数表示地址值
        System.out.println(arr[0]);//[I@4554617c
        System.out.println(arr[0][0]);//0
    }
}
