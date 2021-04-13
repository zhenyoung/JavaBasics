package pers.yangzhen.oop.encapsulation;

public class Encapsulation {
    public static void main(String[] args) {
        Animal tom = new Animal();
        tom.name = "tom";
        tom.age = 2;
        tom.show();
        tom.setLegs(4);
        tom.show();

        /*通过getLegs来获取属性，而不是通过对象调用属性：对象.属性*/
        System.out.println("tom的legs为" + tom.getLegs());
    }

}

