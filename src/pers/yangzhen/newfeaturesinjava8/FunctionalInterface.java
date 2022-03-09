package pers.yangzhen.newfeaturesinjava8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 简单演示一下函数式接口
 *
 * @author yangzhen
 * @create 2021-04-14 16:43
 */
public class FunctionalInterface {

    public void happyTime(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }
    @Test
    public void test1() {
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double price) {
                System.out.println("商品价格为：" + price);
            }
        });
        System.out.println("***********************************");
        //Lambda表达式
        happyTime(400, price -> System.out.println("商品价格为：" + price));
    }
    
    //根据给定的规则，过滤集合中的字符串，此规则由Predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }
    @Test
    public void test2() {
        List<String> list = Arrays.asList("北京", "南京", "西京", "东京", "普京");

        List<String> filterStrs = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterStrs);

        System.out.println("***********************************");
        //Lambda表达式
        List<String> filterStrs1 = filterString(list, s -> s.contains("京"));
        System.out.println(filterStrs1);

    }

}