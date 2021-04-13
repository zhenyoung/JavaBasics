package pers.yangzhen.oop.encapsulation;

public class Animal {
    String name;//动物名字
    int age;//动物的年龄
    private int legs;//动物的腿的数目

    /*对属性的设置*/
    public void setLegs(int l) {// l为需要设置的腿的数目
        if (l > 0 && l % 2 == 0) {
            legs = l;
        } else {
            legs = -1;
        }
    }

    /*对属性的获取*/
    public int getLegs() {
        return legs;
    }

    public void show() {
        System.out.println("name = " + name + "\tage = " + age + "\tlegs = " + legs);
    }
}
