package pers.yangzhen.oop.constructor;

//        需求：
//        编写两个类，TriAngle和Constructor
//        其中TriAngle类中声明私有的底边长base和高height，同时声明公共方法访问私有变量。此外，提供类必要的构造器
//        Constructor类中使用这些公共方法，计算三角形的面积
public class Constructor {
    public static void main(String[] args) {
        TriAngle angle1 = new TriAngle();
        angle1.setBase(3.0);
        angle1.setHeight(4.9);
        System.out.println("base = " + angle1.getBase() + "\theight = " + angle1.getHeight() + "\tarea = " + angle1.area());

        TriAngle angle2 = new TriAngle(2.0,3.1);
        System.out.println("base = " + angle2.getBase() + "\theight = " + angle2.getHeight() + "\tarea = " + angle2.area());

        Person person = new Person(1.0,2.0);
    }
}


