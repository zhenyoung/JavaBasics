package pers.yangzhen.newfeaturesinjava8;

import org.junit.Test;

import java.util.Comparator;

/**
 * Lambda表达式功能演示
 *
 * @author yangzhen
 * @create 2021-04-14 14:00
 */
public class LambdaShow {
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱中国");
            }
        };
        r1.run();
        System.out.println("***************");
        //Lambda表达式
        Runnable r2 = () -> System.out.println("我是中国人");
        r2.run();
    }

    @Test
    public void test2() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);
        System.out.println("************************");
        // lambda表达式
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        // 更简洁的方法引用形式
//        Comparator<Integer> com2 = Integer::compare;
        int compare2 = com2.compare(32, 21);
        System.out.println(compare2);
        System.out.println("************************");
        //方法引用
        Comparator<Integer> com3 = Integer::compare;
        int compare3 = com3.compare(32, 21);
        System.out.println(compare3);

    }

}
