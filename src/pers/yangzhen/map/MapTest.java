package pers.yangzhen.map;

import org.junit.Test;

import java.util.*;

/**
 * @author yangzhen
 * @create 2021-03-30 21:20
 */
public class MapTest {

    @Test
    public void test1(){
        Map map = new HashMap();
        map = new LinkedHashMap();
        map.put(123,"AA");
        map.put(312,"BB");
        map.put(90,"CC");
        System.out.println(map);
    }


    //以下为Map中的常用方法，主要就是：增、查、改、删，即CRUD

    //增、改、删
    @Test
    public void test2(){
        Map map = new HashMap();
        //Object put(Object key,Object value)将指定的key-value添加到当前的map对象中
        //若key相同，则会替换，就变相地进行了修改操作
        map.put("AA",123);
        map.put("BB",4214);
        map.put("DD",891);
        map.put("CC",523);
        map.put("AA",12613);//修改了"AA"对应的value
        System.out.println(map);

        System.out.println("******************");
        Map map1 = new HashMap();
        map1.put("EE",198);
        map1.put("FF",198);
        map1.put("GG",198);
        System.out.println(map1);
        map1.put("AA",198);
        //void putAll(Map m)将m中的所有key-value对存放到当前map中
        map1.putAll(map);
        System.out.println(map1);
        map1.put("AA",299);
        System.out.println(map1);

        System.out.println("******************");
        //Object remove(object key)移除指定key的key-value对，并返回value
        Object value = map1.remove("CC");
        System.out.println(value);
        System.out.println(map1);

        System.out.println("******************");
        //void clear()清空当前map中的所有数据
        map1.clear();//与 map1 = null 不同，只是把元素清空了，map1仍然存在
        System.out.println(map1);
    }

    //查
    @Test
    public void test3(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put("BB",4214);
        map.put("DD",891);
        map.put("CC",523);
        System.out.println(map);
        //Object get(Object key)获取指定的key对应的value
        System.out.println(map.get("AA"));
        System.out.println("******************");

        //boolean containsKey(Object key)是否包含指定的key
        //boolean containsKey(Object value)是否包含指定的value
        System.out.println(map.containsKey("AA"));
        System.out.println(map.containsValue(891));

        System.out.println("******************");
        //int size()返回map中的key-value对的个数
        //boolean isEmpty()判断当前map是否为空
        //boolean equals(Object obj)判断当前map和参数对象obj是否相等
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }

    //取值
    @Test
    public void test4(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put("BB",4214);
        map.put("DD",891);
        map.put("CC",523);

        //取出所有的key：Set keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("***************");
        //取出所有的value：Collection values()
        Collection values = map.values();
        for(Object obj:values){
            System.out.println(obj);
        }

        System.out.println("***************");
        //取出所有的key-value：Set entrySet()
        //方式一：entrySet()
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while(iterator1.hasNext()){
            Object obj = iterator1.next();
            //entrySet集合中的元素都是entry，而一个key-value对构成一个entry对象
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey()+"------->"+entry.getValue());//getKey()或取当前对象的键，getValue()获取当前对象的值
        }
        //方式二：
        Set keySet = map.keySet();
        Iterator iterator2 = keySet.iterator();
        while (iterator.hasNext()){
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key+"------->"+value);
        }

    }

}
