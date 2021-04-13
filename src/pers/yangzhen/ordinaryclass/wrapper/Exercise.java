package pers.yangzhen.ordinaryclass.wrapper;

import java.util.Scanner;
import java.util.Vector;

public class Exercise {
//      利用Vector代替数组处理:从键盘读入学生成绩（以负数代表输入结束），找出最高分，并输出学生成绩等级。
//      1.提示:数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的长度。而向量类java.util.Vector可以根据需要动态伸缩
//      2.创建Vector对象:Vector v=new Vector();
//      3.给向量添加元素:v.addElement(Object obj); obj必须是对象
//      4.取出向量中的元素:Object obj=v.elementAt(O);
//          ✔注意第一个元素的下标是0，返回值是Object类型的
//      5.计算向量的长度:v.size();
//      6.若与最高分相差：10分内A等，20分内B等，30分内C等，其它D等
    public static void main(String[] args) {
        //1.实例化Scanner，从键盘读取数据
        Scanner input = new Scanner(System.in);
        //2.创建Vector对象：Vector v = new Vector();相当原来的数组
        Vector v = new Vector();
        //3.通过while(true)给Vector中添加元素
        //  3.1添加操作：v.addElement(Object obj)
        //  3.2当输入是负数时，跳出循环

        int maxScore = 0;
        while(true){
            System.out.println("输入成绩：");
            int score = input.nextInt();
            if(score < 0){
                break;
            }
            if(score > 100){
                System.out.println("数据非法，重新输入");
                continue;
            }
            //JDK5.0之前，由于没有自动装箱，所以下面形参必须是一个Object对象
            //JDK5.0之后，有了自动装箱，可以直接将基本数据类型添加到方法的形参中，会自动转换成包装类
//            v.addElement(Object obj);
            v.addElement(score);//自动装箱

            //4.获取学生最大值
            if(maxScore < score){
                maxScore = score;
            }
        }
        //5.遍历Vector，得到每个学生的成绩，并与最大成绩比较，得到每个学生的等级
        char level;
        for(int i = 0;i<v.size();i++){
            Object obj = v.elementAt(i);
            //jdk5.0之前
//                Integer inScore = (Integer) obj;
//                int score = inScore.intValue();
            //jdk5.0之后
            int score = (int)obj;

            if(maxScore - score <= 10){
                level = 'A';
            }else if(maxScore - score <= 20){
                level = 'B';
            }else if(maxScore - score <= 30){
                level = 'C';
            }else{
                level = 'D';
            }
            System.out.println("student" + i + "'s score is " + score + ", level is " + level);
        }

    }
}
