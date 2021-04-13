package pers.yangzhen.oop.classtest;

public class Person {
    String name;//属性
    int age = 1;//属性
    boolean isMale;//属性

    public void talk(String language) {//language：形参，是局部变量
        System.out.println("人能说话，说：" + language);
    }

    public void eat() {
        String food = "黄焖鸡米饭";//局部变量
        System.out.println("人能吃饭，菜式为：" + food);
    }
}
