package pers.yangzhen.oop.classtest;

public class StaticTest1 {
    public static void main(String[] args) {
        System.out.println(Students.age);//子类调用父类中的静态属性
        System.out.println(Students.name);//子类调用自己的静态属性
        Students.eat();//子类调用子类中的静态方法
        Students.talk();//子类调用父类中的静态方法，继承

    }
}

class Person1{
    static String name = "Person";
    static int age = 1;
    public static void eat(){
        System.out.println("父类Person吃饭");
    }
    public static void talk(){
        System.out.println("父类Person说话");
    }
}

class Students extends Person1{

    //属性名相同
    static String name = "Students";
    public static void eat(){
        System.out.println("子类Students吃饭");
    }
}