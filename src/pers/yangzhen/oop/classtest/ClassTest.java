package pers.yangzhen.oop.classtest;

import org.junit.Test;

public class ClassTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "Tom";
        p1.isMale = true;
        Person p2 = new Person();
        System.out.println(p2.name);
        Person p3 = p1;
        p3.age = 10;
        System.out.println(p1.age);

    }
}