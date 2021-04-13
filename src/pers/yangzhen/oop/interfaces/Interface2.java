package pers.yangzhen.oop.interfaces;

//JDK8
public class Interface2{
    public static void main(String[] args) {
        SubClass s = new SubClass();
        //s.method1();//报错
        //SubClass.method1();//报错
        //1.接口调用自己的静态方法
        Interface.method1();//interface：北京
        //Interface.method3();//报错
        System.out.println("**************************************************");

        //2.对象调用默认方法
        s.method2();//SuperClass：上海
        System.out.println("**************************************************");

        //3.类优先原则
        s.method2();//SuperClass：上海
        System.out.println("**************************************************");

        //4.多个接口的默认方法同名问题
        s.method3();//SubClass：南京
        System.out.println("**************************************************");

        //5.调用接口中被重写的方法
        s.myMethod();

    }
}
interface Interface {
    public static void method1(){//可以定义静态方法，有方法体，默认都是public的，可以省略
        System.out.println("interface：北京");

    }

    public default void method2(){//定义默认方法，关键字default，默认都是public的，可以省略
        System.out.println("interface：上海");
    }

    default void method3(){
        System.out.println("interface：南京");
    }
}

interface Interface11{
    default void method3(){
        System.out.println("interface11：南京");
    }
}

class SuperClass{
    public void method2(){
        System.out.println("SuperClass：上海");
    }
    public void method3(){
        System.out.println("SuperClass：南京");
    }
}

class SubClass extends SuperClass implements Interface,Interface11{
    public void method3(){
        System.out.println("SubClass：南京");
    }

    public void myMethod(){
        method3();//调用重写的方法
        super.method3();//调用父类中声明的方法

        //调用接口中的默认方法
        Interface.super.method3();
        Interface11.super.method3();

    }
}