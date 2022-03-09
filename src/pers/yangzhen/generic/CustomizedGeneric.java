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
        // 如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为 Object 类型
        // 如果自定义类是带泛型的，一般在实例化时指明类的泛型
        Order<String> tOrder = new Order<>("张三", 1, "996");
        System.out.println(tOrder.getOrderT());
        tOrder.setOrderT("007");
        System.out.println(tOrder.getOrderT());
    }
    
    @Test
    public void test2() {
        // 由于子类在继承带泛型的父类时，指明了泛型类型，
        // 所以实例化子类时，不再需要指明泛型
        SubOrder subOrder = new SubOrder();
        subOrder.setOrderT("443");
        // 编译不通过，泛型为 String ，而非 Integer
        // subOrder.setOrderT(123);
        System.out.println(subOrder.orderT);
        // 由于 SubOrder1 是泛型类，所以需要指明类型
        SubOrder1<String> subOrder1 = new SubOrder1<>();
        subOrder1.setOrderT("8080");
        System.out.println(subOrder1.orderT);
    }
    
    @Test
    public void test3() {
        Order<String> order = new Order();
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        // 泛型方法在调用时，编译器可以根据实参类型、接收的类型等各种手段自动推断出方法的泛型，
        // 所以后面的泛型方法不用声明类型
        List<Integer> list = order.copyFromArrayToList(arr);
        System.out.println(list);
    }
}

// 泛型类
class Order<T> {
    String orderName;
    int orderId;
    
    // 类的内部结构就可以使用类的泛型
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
    
    // 泛型方法，声明在泛型类 Order 中
    // 这里的方法可以声明为 static ，因为泛型方法与类没有关系
    // 第一个 <E> 表明该方法的泛型为 E ，
    // 同样地，第二个 List<E> 中的 E 使用的是第一个泛型，形参列表、方法体等使用的 E 也是第一个声明的泛型
    public static <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }
        // 也可以调用下面的 addAll 方法
        // Collections.addAll(list, arr);
        return list;
    }
}

// 子类继承父类时，指明泛型类型为 String ，所以此时 SubOrder 就不是一个泛型类了
class SubOrder extends Order<String> {
}

// 此时的 SubOrder1 仍然是泛型类
class SubOrder1<T> extends Order<T> {
}