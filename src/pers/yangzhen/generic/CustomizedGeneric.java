package pers.yangzhen.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义的泛型类、泛型方法
 *
 * @author yangzhen
 * @create 2021-04-05 14:30
 */
public class CustomizedGeneric {

    @Test
    public void test1() {
        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //要求：如果自定义类是带泛型的，习惯在实例化时要指明类的泛型
        Order<Integer> tOrder = new Order<>("张三", 1, 123);//指明泛型为Integer类型
        //一般前面写了Integer，后面就不用写了，会类型推断，这是JDK 7.0的一个新特性
        System.out.println(tOrder.getOrderT());
        tOrder.setOrderT(456);
        System.out.println(tOrder.getOrderT());

    }

    @Test
    public void test2() {
        //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型
        SubOrder subOrder = new SubOrder();
        subOrder.setOrderT("张三");
//        subOrder.setOrderT(123);//编译不通过
        System.out.println(subOrder.orderT);

        SubOrder1<String> subOrder1 = new SubOrder1<>();//由于SubOrder1是泛型类，所以需要指明类型
        subOrder1.setOrderT("李四");
        System.out.println(subOrder1.orderT);

    }

    @Test
    public void test3() {
        Order<String> order = new Order();
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        //泛型方法在调用时，指明泛型参数的类型
        List<Integer> list = order.copyFromArrayToList(arr);
        System.out.println(list);

    }
}

class Order<T> {//目前还不知道是什么类型，实例化时给出
    String orderName;
    int orderId;

    //类的内部结构就可以使用类的泛型
    T orderT;

    public Order() {
    }

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    //泛型方法
    //这里的方法可以声明为static，因为泛型方法与类没有关系
    public static <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }

        return list;
    }
}

class SubOrder extends Order<String> {//子类继承父类时，指明泛型类型为String，所以此时SubOrder就不是一个泛型类了
}

class SubOrder1<T> extends Order<T> {//此时的SubOrder1仍然是泛型类
}