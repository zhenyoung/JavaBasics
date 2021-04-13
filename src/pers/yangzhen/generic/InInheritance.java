package pers.yangzhen.generic;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 泛型在继承方面的体现、通配符的问题
 *
 * @author yangzhen
 * @create 2021-04-05 17:07
 */
public class InInheritance {
    @Test
    public void test1() {
        List<Object> list1 = null;
        List<String> list2 = null;
//    list1 = list2;//编译不通过，此时的list1和list2不具有子父类关系
    }

    @Test
    public void test2() {
        AbstractList<String> list1 = null;
        List<String> list2 = null;
        ArrayList<String> list3 = null;

        list1 = list3;
        list2 = list3;

        List<String> list4 = new ArrayList<>();

    }

    //通配符的问题
    @Test
    public void test3() {
        List<Object> list1 = null;
        List<String> list2 = null;
        List<?> list = null;
        list = list1;
        list = list2;

        //编译通过
//        print(list1);
//        print(list2);

        //
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list3.add("DD");
        list = list3;

        //添加（写入）：对于List<?>不能向其内部添加除null外的数据
//        list.add("DD");
//        list.add('?');
        list.add(null);

        //获取（读取）：允许读取数据，读取的数据类型为Object
        Object o = list.get(0);
        System.out.println(o);

    }

    public void print(List<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

    //带限制条件的通配符
    @Test
    public void test4() {
        List<? extends Person1> list1 = null;
        List<? super Person1> list2 = null;

        List<Student> list3 = new ArrayList<Student>();
        List<Person1> list4 = new ArrayList<Person1>();
        List<Object> list5 = new ArrayList<Object>();

//        list1 = list2;//编译不通过，范围不一致
        list1 = list3;//泛型Student是Person1的子类，该引用可以赋值
        list1 = list4;//泛型Person1，可以调用
//        list1 = list5;//编译不通过，泛型Object是Person1的父类，不能赋值，类似父类对象不能给子类引用赋值

//        list2 = list3;//编译不通过，Student不是Person1的父类
        list2 = list4;//泛型Person1，可以赋值
        list2 = list5;//泛型Object是Person1的父类，可以赋值

        //1.读取数据
        list1 = list4;
        Object obj = list1.get(0);//Object类型可以接收
        Person1 person1 = list1.get(0);//小一点范围Person类型也可以接收
//        Student s = list1.get(0);//再小一点范围Student类型就不能接收了
        list2 = list4;
        Object object = list2.get(0);//只能Object接收
//        Person1 person2 = list2.get(0);//小一点范围Person类型则也可以接收

        //2.写入数据：带限制的通配符泛型是可以写入一些数据的
//        list1.add(new Student());//编译不通过，不能添加数据
//        list1.add(new Person1());//编译不通过，不能添加数据
//        list1.add(new Object());//编译不通过，不能添加数据

        //编译通过
        list2.add(new Person1());
        list2.add(new Student());



    }

}

class Person1{
}

class Student extends Person1 {
}