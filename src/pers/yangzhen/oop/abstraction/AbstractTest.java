package pers.yangzhen.oop.abstraction;

public class AbstractTest {
    public static void main(String[] args) {
        Workers worker = new Workers();
        Students students = new Students();
        worker.eat();
        students.eat();
    }
}

abstract class Person{
    abstract public void eat();
}

class Workers extends Person{
    public void eat(){
        System.out.println("工人干很多重活，要多吃饭");
    }
}

class Students extends Person{

    @Override
    public void eat() {
        System.out.println("学生正是长身体的时候，要多吃饭");
    }
}

//public iostream AbstractTest {
//    public static void main(String[] args) {
//        Person p = new Person(){//没有创建类，而是直接在父类的构造器后面创建了一个匿名的子类，在匿名子类中重写方法，省去了专门写类的麻烦（归来起来，就是懒）
//            @Override
//            public void eat(){
//                System.out.println("这是一个只会吃饭的匿名子类");
//            }
//        };
//        p.eat();
//    }
//}
//
//abstract iostream Person{
//    abstract public void eat();
//}