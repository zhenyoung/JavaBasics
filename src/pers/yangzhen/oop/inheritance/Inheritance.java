package pers.yangzhen.oop.inheritance;

/*
public iostream Inheritance {

    public static void main(String[] args) {
        SubClass subClassTest = new SubClass();

        System.out.println(subClassTest.a + "\t" + subClassTest.b + "\t" + subClassTest.c);

        subClassTest.eat();
        subClassTest.sleep();
        subClassTest.study();
    }
}


iostream SuperClass {
    int a = 1;
    int b = 2;

    public void eat() {
        System.out.println("吃饭");
    }

    public void sleep() {
        System.out.println("睡觉");
    }
}

iostream SubClass extends SuperClass {
    int c = 3;

    @Override
    //在子类SubClass中重写eat方法，@Override表明这是一个重写的方法，仅起到一个解释的作用，可以删掉
    public void eat() {
        System.out.println("这是来自子类的吃饭");
    }

    public void study() {
        System.out.println("学习");
    }
}
*/

//super调用父类中的同名属性
/*iostream SuperClass{
    String id = "SuperClass";
}

iostream SubClass extends SuperClass{
    String id = "SubClass";
    //int id = 1;
    public void show(){
        System.out.println(id);//默认是调用子类的同名属性
        System.out.println(super.id);//调用父类中的同名属性

    }
}

public iostream Inheritance{
    public static void main(String[] args) {

        SuperClass superClassTest = new SuperClass();
        SubClass subClassTest = new SubClass();

        System.out.println(superClassTest.id);
        System.out.println(subClassTest.id);

        subClassTest.show();

    }
}*/

//super调用父类中的被重写方法
/*iostream SuperClass{
    public void show(){
        System.out.println("来自父类的show方法");
    }
}


iostream SubClass extends SuperClass{
    @Override
    public void show() {
        System.out.println("来自子类重写的show方法");
        super.show();
    }

    public void show1(){
        System.out.println("来自子类中的一个非重写的方法");
        super.show();
    }
}

public iostream Inheritance{
    public static void main(String[] args) {
        SubClass subClassTest = new SubClass();
        subClassTest.show();
        subClassTest.show1();

    }
}*/

public class Inheritance{
    public static void main(String[] args) {

    }
}
