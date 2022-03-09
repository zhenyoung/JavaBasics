package pers.yangzhen.exercises.datatype;

public class Operator {
    public static void main(String[] args){
        boolean judgement1 = true;
        int number1 = 1;
        if(judgement1 && (number1++ > 0))
            System.out.println(number1);
        else
            System.out.println(number1);

        boolean judgement2 = true;
        int number2 = 1;
        if(judgement2 & (number2++ > 0))
            System.out.println(number2);
        else
            System.out.println(number2);

        boolean judgement3 = false;
        int number3 = 1;
        if(judgement3 && (number3++ > 0))
            System.out.println(number3);
        else
            System.out.println(number3);

        boolean judgement4 = false;
        int number4 = 1;
        if(judgement4 & (number4++ > 0))
            System.out.println(number4);
        else
            System.out.println(number4);

        byte number5 = 127;
        byte number6 = (byte)(number5 + 1);
        System.out.println(number6);

        //注：所有的位运算都是对补码进行操作的，且符号位不参与移位
//左移操作
//①
        int a = 44;
        int b = a << 2;
        System.out.println(b);
//0 000 0000 0010 1100		44
//0 000 0000 1011 0000		结果176
//②
        int c = -8319;
        int d = c << 2;
//1 010 0000 0111 1111		原码-8319
//1 101 1111 1000 0001		补码-8319
//1 111 1110 0000 0100		左移结果（补码）
//1 000 0001 1111 1100		左移结果（原码）-33276
        System.out.println(d);//-33276

//右移操作
       int e = -36;
        int f = e >> 2;
//1 000 0000 0010 0100		原码-36
//1 111 1111 1101 1100		补码-36
//1 111 1111 1111 0111		右移结果（补码）
//1 000 0000 0000 1001		右移结果（原码）-9
        System.out.println(f);//-9

    }
}