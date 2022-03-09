package pers.yangzhen.exercises;

public class InnerClassTest {
    public static void main(String[] args){

        //创建Dog实例（静态成员的内部类）
        Animal.Dog dog = new Animal.Dog();//内部类作为结构被外部类调用再去创建对象
        dog.show();//内部类的对象调用方法

        //创建Bird实例（非静态的成员内部类）
        //静态成员内部类可以被外部类直接调用从而去创建对象
        //而非静态的成员内部类必须先创建对象，通过对象去调用内部类从而调用对象
        Animal a = new Animal();
        Animal.Bird bird = a.new Bird();//a.new Bird()通过对象去调内部类的构造器
        bird.sing();
        bird.display("小动物");
    }
}

class Animal{
    String name = "小动物";
    int age;

    public void eat(){
        System.out.println("吃饭");
    }

    //静态成员内部类
    static class Dog{
        String name = "小狗";
        int age;
        public void show(){
            System.out.println("Dog吃饭");
            //eat();//错误的，静态不能调非静态
        }
    }

    //非静态成员内部类
    class Bird{
        String name = "小鸟";
        int age;
        public Bird(){

        }
        public void sing(){
            System.out.println("我是一个小小小小鸟");
            eat();//调用外部类的非静态属性，默认省略了 Animal.this.
        }

        //
        public void display(String name){
            System.out.println(name);//调用形参
            System.out.println(this.name);//调用形参Bird内部类的属性
            System.out.println(Animal.this.name);//调用Animal外部类的属性
        }
    }

}
