package pers.yangzhen.drafts;

import org.junit.Test;

public class Chinese {
    String name;
    int age;
    static String nation;

    @Test
    public void eat() {
        System.out.println("中国人吃中餐");
        //调用非静态结构
        this.info();
        //调用静态结构
        walk();
        System.out.println("nation:" + nation);//类.静态属性 中可以省略类
    }

    public static void show() {
        System.out.println("我是一个中国人！");
        //不能调用非静态的属性、方法
//        eat();
//        name = "Tom";
        //可以调用静态的结构
        System.out.println(Chinese.nation);
        walk();//类.静态方法 中可以省略类

    }

    public void info() {
        System.out.println("name:" + name + ", age:" + age);
    }

    public static void walk() {

    }

}
