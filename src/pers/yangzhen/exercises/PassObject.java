package pers.yangzhen.exercises;

import java.util.Scanner;

/*
需求：
①定义一个Circle类，包含一个double型的radius属性代表圆的半径，一个findArea方法返回圆的面积
②定义一个PassObject类，在类中定义一个方法printAreas()，该方法定义：public void printAreas(Circle c,int time)
在printAreas方法中打印输出1到time之间的每个整数半径值，以及对应的面积。如：time为5，则输出半径1,2,3,4,5以及对应的圆面积
③在main方法中调用printArea()方法，调用完毕后输出当前半径值。实例如下：
time:3
Radius   Area
1.0      3.141592653589793
2.0      12.566370614359172
3.0      28.274333882308138
now radius is 4.0
 */
public class PassObject {

    public void printAreas(Circle c,int time){
        //设置圆的半径
        for(double i = 1;i <= time;i++){
            c.radius = i;
            System.out.println(c.radius + "      " + c.findArea(i));
        }
        c.radius = time + 1;
    }

    public static void main(String[] args) {
        System.out.print("time: ");
        Scanner input = new Scanner(System.in);
        int time = input.nextInt();
        System.out.println("Radius   Area");
        Circle c = new Circle();
        PassObject test = new PassObject();
        test.printAreas(c,time);
        System.out.println("now radius is " + c.radius);

    }
}

class Circle{
    double radius;
    double area;

    public double findArea(double radius){
        area = Math.PI * radius * radius;
        return area;
    }
}