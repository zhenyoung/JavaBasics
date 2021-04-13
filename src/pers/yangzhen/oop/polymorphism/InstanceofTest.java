package pers.yangzhen.oop.polymorphism;

public class InstanceofTest {
    public static void main(String[] args) {
        //1.编译不通过
//        Man m1 = new Woman();

        //2.编译通过，运行不通过
//        Person p1 = new Woman();
//        Man m1 = (Man) p1;

        //3.编译通过，运行时通过
        Object obj = new Woman();
        Person p = (Person) obj;

        /*  a instanceof A    判断对象a是否是类A的实例，如果是，返回true，如果不是，返回false
        使用情境：为了避免再向下转型中出现ClassCastException的异常，再向下转型之前，使用instanceof的判断，一旦返回true，就进行向下转型，否则就不向下转型
        如果：a instanceof A返回true，且a instanceof B也返回true，那么类B是类A的父类
        */

        Person person = new Person();
        Man man = new Man();
        Woman woman = new Woman();
        if (person instanceof Person) {
            System.out.println("Person类的对象是Person类的一个实例");//其他的类型同理
        }
        if (man instanceof Person) {
            System.out.println("子类Man的对象也是父类Person类型的一个实例");
        }
        if (woman instanceof Person) {
            System.out.println("子类Woman的对象也是父类Person类型的一个实例");
        }
        if (!(person instanceof Man || person instanceof Woman)) {//同时为false时才会执行
            System.out.println("父类Person的对象不是子类Man和Woman的一个实例");
        }
        System.out.println();
        Person manInPerson = new Man();
        Person womanInPerson = new Woman();
        if (manInPerson instanceof Person && manInPerson instanceof Man) {
            Man man1 = (Man) manInPerson;
            System.out.println("在多态性中，子类Man的对象manInPerson是父类Person的一个实例，也是Man的一个实例");
        }

        if (womanInPerson instanceof Person && womanInPerson instanceof Woman) {
            Woman woman1 = (Woman) womanInPerson;
            System.out.println("在多态性中，子类Woman的对象womanInPerson是父类Person的一个实例，也是Woman的一个实例");
        }

        if (!(manInPerson instanceof Woman || womanInPerson instanceof Man)) {
            System.out.println("在多态性中，子类对象之间不是彼此类型的实例。因为没有继承关系，所以子类之间没有任何联系");
        }

    }
}

class Person {

}

class Man extends Person {

}

class Woman extends Person {

}