package pers.yangzhen.newfeaturesinjava8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式的使用
 * 1.举例：(o1,o2) -> Integer.compare(o1,o2)
 * 2.格式：
 *      ->：lambda操作符 或 箭头操作符
 *      箭头左边：lambda形参列表（其实就是接口中抽象方法的形参列表）
 *      箭头右边：lambda体（其实就是重写的抽象方法的方法体）
 * 3.Lambda表达式的使用：（分为6种情况介绍）
 * 4.Lambda表达式的本质就是作为接口（接口必须是函数式接口，即只有一个方法）的实例，如果没有接口，Lambda表达式就没有意义了
 * 5.总结：
 *      箭头左边：lambda形参列表的参数类型可以省略(类型推断)，如果形参列表只有一个参数，则省略()
 *      箭头右边：lambda体应该使用一对{}包裹，如果只有一条执行语句（可能是return语句），省略这一对{}和return关键字
 * @author yangzhen
 * @create 2021-04-14 14:15
 */
public class LambdaTest {

    //语法格式1：无参，无返回值
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {//run方法无形参列表，无返回值
                System.out.println("我爱中国");
            }
        };
        r1.run();
        System.out.println("*******************************************");
        //Lambda表达式
        Runnable r2 = () -> {
            System.out.println("我是中国人");
        };
        r2.run();
    }

    //语法格式2：Lambda需要一个参数，但是没有返回值
    @Test
    public void test2() {
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {//参数
                System.out.println(s);
            }
        };
        con.accept("北京欢迎你");
        System.out.println("*******************************************");
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("中国北京欢迎你");
    }

    //语法格式3：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
    @Test
    public void test3(){
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("北京欢迎你");
        System.out.println("*******************************************");
        Consumer<String> con2 = (s) -> {
            System.out.println(s);
        };
        con2.accept("中国北京欢迎你");
    }

    //语法格式4：Lambda若只需要一个参数时，参数的小括号可以省略
    @Test
    public void test4(){
        Consumer<String> con1 = (s) -> {
            System.out.println(s);
        };
        con1.accept("北京欢迎你");
        System.out.println("*******************************************");
        Consumer<String> con2 = s -> {
            System.out.println(s);
        };
        con2.accept("中国北京欢迎你");

    }

    //语法格式5：Lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test5(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12, 21));

        System.out.println("*******************************************");
        Comparator<Integer> com2 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(12, 6));
    }

    //语法格式6：当Lambda体只有一条语句时，return与大括号都可以省略
    @Test
    public void test6(){
        Comparator<Integer> com1 = (o1,o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(com1.compare(12, 6));
        System.out.println("*******************************************");
        Comparator<Integer> com2 = (o1,o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(12, 21));

    }

    @Test
    public void test7(){
        Consumer<String> con1 = s -> {
            System.out.println(s);
        };
        con1.accept("北京欢迎你");
        System.out.println("*******************************************");
        Consumer<String> con2 = s -> System.out.println(s);
        con2.accept("中国北京欢迎你");

    }



}
