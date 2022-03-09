package pers.yangzhen.map;

import org.junit.Test;

import java.util.*;

/**
 * @author yangzhen
 * @create 2021-03-30 21:20
 */
public class MapTest {
    @Test
    public void test1() {
        Map map = new HashMap();
        map = new LinkedHashMap();
        map.put(123, "AA");
        map.put(312, "BB");
        map.put(90, "CC");
        System.out.println(map);
    }
    
    // 以下为 Map 中的常用方法，主要就是：增、查、改、删，即 CRUD
    // 增、改、删
    @Test
    public void test2() {
        Map map = new HashMap();
        // Object put(Object key,Object value) 将指定的 key-value 添加到当前的 map 对象中
        // 若 key 相同，则会替换，相当于变相地进行了修改 key 的 value 操作(key 的 不可重复性)
        map.put("AA", 123);
        map.put("BB", 4214);
        map.put("DD", 891);
        map.put("CC", 523);
        // 修改了 "AA" 对应的 value
        map.put("AA", 12613);
        System.out.println(map);
        System.out.println("******************");
        Map map1 = new HashMap();
        map1.put("EE", 198);
        map1.put("FF", 198);
        map1.put("GG", 198);
        System.out.println(map1);
        map1.put("AA", 198);
        // void putAll(Map m) 将 m 中的所有 key-value 对存放到当前 map 中
        // map 中的 "AA" 会将原来 map1 中的 "AA" 的值覆盖为 12613 ，并且返回旧值
        map1.putAll(map);
        System.out.println(map1);
        System.out.println(map1.put("AA", 299));
        System.out.println(map1);
        System.out.println("******************");
        // Object remove(object key) 移除指定 key 的 key-value 对，并返回 value
        Object value = map1.remove("CC");
        System.out.println(value);
        System.out.println(map1);
        System.out.println("******************");
        // void clear() 清空当前 map 中的所有数据，
        // 与 map1 = null 不同，该方法只是把元素清空了，map1 仍然存在
        map1.clear();
        System.out.println(map1);
    }
    
    // 查
    @Test
    public void test3() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put("BB", 4214);
        map.put("DD", 891);
        map.put("CC", 523);
        System.out.println(map);
        // Object get(Object key) 获取指定的 key 对应的 value
        System.out.println(map.get("AA"));
        System.out.println("******************");
        // boolean containsKey(Object key) 是否包含指定的 key
        // boolean containsKey(Object value) 是否包含指定的 value
        System.out.println(map.containsKey("AA"));
        System.out.println(map.containsValue(891));
        System.out.println("******************");
        // int size() 返回 map 中键值对的个数
        // boolean isEmpty() 判断当前 map 是否为空 {}
        // boolean equals(Object obj) 判断当前 map 和 obj 是否相等
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }
    
    // 取值
    @Test
    public void test4() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put("BB", 4214);
        map.put("DD", 891);
        map.put("CC", 523);
        // 取出所有的 key ：Set keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("***************");
        // 取出所有的 value：Collection values()
        Collection values = map.values();
        for (Object obj : values) {
            System.out.println(obj);
        }
        System.out.println("***************");
        // 取出所有的 key-value ：Set entrySet()
        Set entrySet = map.entrySet();
        // Set 集合只能通过迭代器去遍历
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            // 一个 key-value 对构成一个 Entry 对象(Entry 是 Map 接口的一个内部接口)
            // entrySet() 返回所有的键值对(即所有的 Entry 对象)，存储在 Set 集合中
            Map.Entry entry = (Map.Entry) obj;
            // getKey() 获取当前对象的键，getValue() 获取当前对象的值
            System.out.println(entry.getKey() + "------->" + entry.getValue());
        }
    }
}