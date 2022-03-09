package pers.yangzhen.ordinaryclass.object;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @Description
 * @Author youngzhen
 * @Date 2022/2/20 16:38
 */
public class Clone {
    @Test
    public void test1() throws CloneNotSupportedException {
        Human beCloned = new Human();
        Human cloned = beCloned.clone();
        System.out.println(beCloned.name + beCloned.age + beCloned.date.getYear());
        System.out.println(cloned.name + cloned.age + cloned.date.getYear());
        cloned.name = "liSi";
        cloned.age = 1000;
        cloned.date.setYear(2022);
        System.out.println(beCloned.name + beCloned.age + beCloned.date.getYear());
        System.out.println(cloned.name + cloned.age + cloned.date.getYear());
    }
}
class Human implements Cloneable{
    // class String is unchangeable because of modifier final
    String name = "zhangSan";
    int age = 100;
    // class Date is changeable, but class LocalDate is unchangeable,
    // so we use the Date to test in spite of the deprecation of Date
    Date date = new Date(2000, Calendar.JANUARY,1);
    
    // shallow copy: default way to clone object in class Object's method clone()
//    @Override
//    public Human clone() throws CloneNotSupportedException {
//        return (Human) super.clone();
//    }
    
    // deep copy: customized way to clone object
    @Override
    public Human clone() throws CloneNotSupportedException {
        Human clone = (Human) super.clone();
        clone.date = (Date) date.clone();
        return clone;
    }
}
