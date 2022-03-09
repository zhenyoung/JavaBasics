package pers.yangzhen.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 通配符
 * @Author youngzhen
 * @Date 2022/3/1 12:58
 */
public class Wildcards {
    // 不带限制的通配符
    @Test
    public void test1() {
        List<?> list;
        List<Object> list1 = null;
        List<String> list2 = null;
        list = list1;
        list = list2;
        // 编译通过
        printList(list1);
        printList(list2);
        
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list3.add("DD");
        list = list3;
        // 编译不通过，
        // 因为 ? 类型并不确定，因此不能向 List<?> 内部添加除 null 以外的数据
        // list.add("DD");
        // list.add('?');
        list.add(null);
        
        // 读取数据，读取的数据类型为 Object
        Object o = list.get(0);
        System.out.println(o);
    }
    
    public void printList(List<?> list) {
        // 集合使用增强 for 遍历(本质上还是使用了迭代器，相当于已经写好的一种遍历方式)
        for (Object obj : list) {
            System.out.println(list);
        }
        // 也可使用迭代器遍历
//        Iterator<?> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
    }
    
    // 带限制条件的通配符
    @Test
    public void test2() {
        List<? extends Person1> list1;
        List<? super Person1> list2;
        List<Student> list3 = new ArrayList<>();
        List<Person1> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();
        // 编译不通过，范围不一致
        // list1 = list2;
        // 编译通过，泛型 Student 是 Person1 的子类
        list1 = list3;
        // 编译通过，泛型 Person1
        list1 = list4;
        // 编译不通过，泛型 Object 是 Person1 的父类，类似父类对象不能给子类引用赋值
        // list1 = list5;
    
        // 编译不通过，Student 不是 Person1 的父类
        // list2 = list3;
        // 编译通过，泛型 Person1
        list2 = list4;
        // 编译通过，泛型 Object 是 Person1 的父类
        list2 = list5;
        
        // 1. 读取数据
        // list1 的泛型是 Person1 及其子类，那么根据多态性：
        // 只能由大于等于其最大类型的 Person 的类型接收，那么接受类型自然也就是 Person1 及其父类了，
        // 其他也是同理
        list1 = list4;
        // Object 类型可以接收
        Object obj = list1.get(0);
        // 小一点范围 Person1 类型也可以接收
        Person1 person1 = list1.get(0);
        // 再小一点范围 Student 类型就不能接收了
        // Student s = list1.get(0);
        list2 = list4;
        // 只能 Object 接收，因为泛型为 Person1 及其父类，而 Person1 并未显式继承其他类，
        // 故其父类仅仅为 Object，那么自然最大的类型就是 Object 了，所以只能由 Object 接受
        Object object = list2.get(0);
        // Person1 类型都不能接收
        // Person1 person2 = list2.get(0);
        
        // 2. 写入数据：带限制的通配符是可以写入一些类型数据的
        // 编译不通过，不能添加数据
        // list1.add(new Student());
        // 编译不通过，不能添加数据
        // list1.add(new Person1());
        // 编译不通过，不能添加数据
        // list1.add(new Object());
        // 编译通过
        list2.add(new Person1());
        list2.add(new Student());
        // 编译不通过
        // list2.add(new Object());
    }
}

class Person1 {
}

class Student extends Person1 {
}