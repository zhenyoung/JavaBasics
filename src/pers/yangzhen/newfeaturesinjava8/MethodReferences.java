package pers.yangzhen.newfeaturesinjava8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 使用情境：接口中抽象方法的形参列表和返回类型与方法引用中的相同
 *
 * @author yangzhen
 * @create 2021-04-14 21:38
 */
public class MethodReferences {

    //情况一：对象::实例方法
    //System.out中的public void println(String x)
    //Consumer<T>中的void accept(T t)
    @Test
    public void test1() {
        // accept() 的方法体
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("北京");
        System.out.println("************************");
        // 方法引用
        Consumer<String> con2 = System.out::println;
        con2.accept("beijing");
    }

    //情况二：类::静态方法
    //Comparator中的int compare(T t1,T t2)
    //Integer中的int compare(T t1,T t2)
    @Test
    public void test2() {
        Comparator<Integer> com1 = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(com1.compare(12, 21));
        System.out.println("************************");
        //方法引用
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(12, 3));
    }

    //Function<T,R>中的R apply(T t)
    //Math中的Long round(Double d)
    @Test
    public void test3() {
        Function<Double, Long> func1 = new Function<Double, Long>() {
            @Override
            public Long apply(Double d) {
                return Math.round(d);//long round(double d)四舍五入
            }
        };
        System.out.println(func1.apply(2.1));//2
        System.out.println("***********************");
        Function<Double, Long> func2 = d -> Math.round(d);
        System.out.println(func2.apply(12.3));//12
        System.out.println("***********************");
        Function<Double, Long> func3 = Math::round;
        System.out.println(func3.apply(3.3));//3

    }

    //情况三：类::实例方法（使用较少）
    //Comparator中的int compare(T t1,T t2)
    //String中的int t1.compareTo(String t2)
    @Test
    public void test4() {
        Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("abc", "abd"));//'c'-'d'
        System.out.println("************************");
        //方法引用
        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("abd", "abm"));//'d'-'m'
    }

    //BiPredicate中的boolean test(T t1,T t2)
    //String中的boolean t1.equals(t2)
    @Test
    public void test5() {
        BiPredicate<String, String> pre1 = (s1, s2) -> s1.equals(s2);
        System.out.println(pre1.test("abc", "abc"));
        System.out.println("**********************");
        BiPredicate<String, String> pre2 = String::equals;
        System.out.println(pre1.test("abc", "abm"));
    }
    
}
