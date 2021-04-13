package pers.yangzhen.oop.polymorphism;

public class AnimalTest {

    public static void main(String[] args) {
        AnimalTest test = new AnimalTest();
        test.func(new Dog());

        test.func(new Cat());
    }

    /*如果没有多态性的话，那么如果想分别使用Dog和Cat的eat方法和shout方法，就必须重写方法，如果有多个动物，那么就要重写多次。
    这样一来，太过于繁琐，写了太多重复冗余的无用代码
    */
    public void func(Animal animal){
        animal.eat();
        animal.shout();
    }

    public void func(Dog dog){
        dog.eat();
        dog.shout();
    }

    public void func(Cat cat){
        cat.eat();
        cat.shout();
    }

}

class Animal {
    public void eat() {
        System.out.println("动物，进食");
    }

    public void shout() {
        System.out.println("动物，叫");
    }
}

class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }
    @Override
    public void shout() {
        System.out.println("汪！汪！汪！");
    }
}
class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
    @Override
    public void shout() {
        System.out.println("喵！喵！喵！");
    }
}