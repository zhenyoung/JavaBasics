package pers.yangzhen.ordinaryclass.math;

public class GetRandomNumber {
    public static void main(String[] args) {

        //随机数获取
        double Test1 = Math.random();
        //Math类中的random方法返回一个[0.0,1.0)之间的随机数
        double Test2 = Math.random() * 90 + 10;
        //通过处理，产生[10.0,100.0)之间的随机数

        int value = (int) (Math.random() * 90 + 10);
        //通过强转产生[10,100)之间的整数即[10,99]
        System.out.println(value);
        //由上不难得出产生任意范围[a,b]内的随机整数公式:
        //(int)(Math.random()*(b - a + 1) + a)

    }
}
