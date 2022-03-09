package pers.yangzhen.oop.classtest;

/**
 * field and static method while in inheritance
 *
 * @author yangzhen
 * @create 2021-06-07 16:06
 */
public class StaticTest2 {

    public static void main(String[] args) {
        SuperClass Instance1 = new SuperClass();
        System.out.println(Instance1.field);
        Instance1.method1();
        Instance1.method2();
        System.out.println("***********************************************************");
        SubClass Instance2 = new SubClass();
        System.out.println(Instance2.field);
        Instance2.method1();
        Instance2.method2();
        System.out.println("***********************************************************");
        SuperClass Instance3 = new SubClass();
        System.out.println(Instance3.field);
        Instance3.method1();
        Instance3.method2();

    }
}

class SuperClass {
    int field = 1;

    public static void method1() {
        System.out.println("this static method is from SuperClass");
    }
    public void method2(){
        System.out.println("this non static method is from SuperClass");
    }
}

class SubClass extends SuperClass {
    int field = 2;
    public static void method1(){
        System.out.println("this static method is from SubClass");
    }

    @Override
    public void method2() {
        System.out.println("this non static method is from SubClass");
    }
}
