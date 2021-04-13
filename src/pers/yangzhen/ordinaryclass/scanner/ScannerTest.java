package pers.yangzhen.ordinaryclass.scanner;

//1.导包java.util（Scanner类在该包中）
import java.util.Scanner;
public class ScannerTest {
    public static void main(String[] args){
        //2.Scanner类的实例化：声明一个对象test
        Scanner test = new Scanner(System.in);
        //3.test调用Scanner类中的方法
        int number = test.nextInt();//number接收
        System.out.println(number);

        System.out.println("姓名：");
        String name = test.next();//next方法的返回类型为字符串
        System.out.println(name);

        System.out.println("年龄:");
        int age = test.nextInt();//nextInt方法返回类型为int
        System.out.println(age);

        System.out.println("体重（kg）：");
        double weight = test.nextDouble();//nextDouble方法返回double类型
        System.out.println(weight);

        System.out.println("你是否爱我（true or false）：");
        boolean isLove = test.nextBoolean();//nextBoolean方法返回boolean类型
        System.out.println(isLove);

        //很遗憾，Scanner类中没有提供相关的方法去从键盘获取char型字符，只能获取字符串
        System.out.println("性别（男/女）：");
        String gender = test.next();
        char genderChar = gender.charAt(0);
        //String类下的charAt方法可以获取字符串的指定索引下的字符，参数即为索引值，第一个字符的索引值为0
        System.out.println(genderChar);
        System.out.println("请输入三个数：");
        Scanner input = new Scanner(System.in);
        int[] array=new int[3];//数组初始化
        for(int index = 0; index < array.length; index++) {
            array[index] = input.nextInt();
        }

        if(array[2] > array[1]){
            if(array[2] > array[0]){
                if(array[1] > array[0]) {
                    System.out.println("从小到大：" + array[0] + '\t' + array[1] + '\t' + array[2]);
                }else {
                    System.out.println("从小到大：" + array[1] + '\t' + array[0] + '\t' + array[2]);
                }
            }else{
                System.out.println("从小到大：" + array[1] + '\t' + array[2] + '\t' + array[0]);
            }
        }
        else if(array[1] > array[0]){
            if(array[2] > array[0]) {
                System.out.println("从小到大：" + '\t' + array[0] + '\t' + array[2] + '\t' + array[1]);
            }else {
                System.out.println("从小到大：" + '\t' + array[2] + '\t' + array[0] + '\t' + array[1]);
            }
        }else{
            System.out.println("从小到大：" + '\t' + array[2] + '\t' + array[1] + '\t' + array[0]);
        }

        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();//next方法遇分隔符（空格、tab、回车等）结束
        String str2 = scan.nextLine();//nextLine方法可接收任意字符串
        System.out.println(str1);
        System.out.println(str2);

    }
}
