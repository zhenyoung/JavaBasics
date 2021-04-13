package pers.yangzhen.generic;

import org.junit.Test;

import java.util.*;

/**
 * @author yangzhen
 * @create 2021-04-05 10:25
 */
public class GenericTest {

    //不使用泛型的情况
    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(89);
        list.add(92);
        list.add(73);
        list.add(70);
        list.add("Tom");

        //问题1：类型不安全
        for (Object score : list) {
            //问题2：强转时，可能出现ClassCastException
            int stuScore = (Integer) score;
            System.out.println(stuScore);
        }
    }

    //以ArrayList为例
    @Test
    public void test2() {
        ArrayList<Integer> integers = new ArrayList<>();//这里不能使用基本数据类型，因为这里是不会自动装箱的
        integers.add(89);
        integers.add(92);
        integers.add(73);
        integers.add(70);
        //编译时，就会进行类型检查，保证数据的安全
//        integers.add("Tom");//此时若添加字符串则会报错
        for (Integer score : integers){
            System.out.println(score);
        }
    }

    //以HashMap为例
    @Test
    public void test3(){
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("Tom",12);
        map.put("Mary",123);
        map.put("Mike",35);

        //泛型的嵌套
        //entrySet()返回Set类型，Set类型的泛型是Entry，而Entry的泛型又是String（key的类型）和Integer（value的类型）
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        //iterator()返回Iterator类型，同上，使用了泛型嵌套
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "----" + value);
        }


    }
}
