package pers.yangzhen.generic;

import org.junit.Test;

import java.util.*;

/**
 * @author yangzhen
 * @create 2021-04-05 10:25
 */
public class GenericShow {
    // 不使用泛型时候只能强转，而强转必须建立在多态的前提下(使用 instance 进行判断是否是一个实例)，
    // 否则会出现 ClassCastException 异常
    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(89);
        list.add(92);
        list.add(73);
        list.add(70);
        list.add("Tom");
        // 问题1：类型不安全
        for (Object score : list) {
            // 问题2：强转时，可能出现 ClassCastException
            int stuScore = (Integer) score;
            System.out.println(stuScore);
        }
    }
    
    // 以 ArrayList 为例
    @Test
    public void test2() {
        // 泛型类必须是类，因此这里不能使用基本数据类型，因为这里不会自动装箱的
        // 后面构造器的 <> 可以不写类型，编译器会根据前面引用中的类型做类型推断，这是 JDK 7.0 的一个新特性
        ArrayList<Integer> integers = new ArrayList<>();
        // 方法中的参数会自动装箱、拆箱
        integers.add(89);
        integers.add(92);
        integers.add(73);
        integers.add(70);
        // 编译时，就会进行类型检查以保证数据的安全。所以此时若添加字符串则会报错，
        // 若没有使用泛型，那么在运行时才会抛出 ClassCastException 异常
        // integers.add("Tom");
        for (Integer score : integers) {
            System.out.println(score);
        }
    }
    
    // 以 HashMap 为例
    @Test
    public void test3() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Tom", 12);
        map.put("Mary", 123);
        map.put("Mike", 35);
        // 泛型嵌套：
        // entrySet 返回 Set 类型，Set 类型的泛型是 Entry( Map 接口的一个内部接口)，
        // 而 Entry 的泛型又是 String( key 的类型) 和 Integer( value 的类型)，键值对
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        // iterator 返回 Iterator 类型，也进行了泛型嵌套
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> e = iterator.next();
            System.out.println(e.getKey() + "----" + e.getValue());
        }
        // 也可用增强 for 循环
        // for (Map.Entry<String, Integer> e : entry) {
        //    System.out.println(e.getKey() + "----" + e.getValue());
        //}
    }
}
