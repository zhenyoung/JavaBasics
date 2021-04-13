package pers.yangzhen.array;
import java.util.Scanner;

public class YangHuiTriangle {
    public static void main(String[] args) {
        //使用二维数组打印杨辉三角
        System.out.print("输入行数：");
        Scanner scan = new Scanner(System.in);
        int column = scan.nextInt();
        int[][] yangHui = new int[column][];

        for(int i = 0;i < yangHui.length;i++){
            yangHui[i] = new int[i + 1];//第i行有（i+1）列
            yangHui[i][0] = yangHui[i][i] = 1;//每行第一个和最后一个赋值0

            //给每行的非行首行尾的元素赋值
                for(int j = 1;j < yangHui[i].length - 1;j++){
                    yangHui[i][j] = yangHui[i-1][j-1] + yangHui[i-1][j];
                }
        }

        //遍历二维数组
        for (int[] ints : yangHui) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}
