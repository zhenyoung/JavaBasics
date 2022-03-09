package pers.yangzhen.collection;

import org.junit.Test;

import java.util.*;

/**
 * List 接口中的常用方法
 * @author yangzhen
 * @create 2021-03-27 20:01
 */
public class ListTest {
    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Date());
        list.add(456);
        // boolean add(Object obj) 在集合末尾增加元素 obj
        // boolean add(int index,Object ele) 在 index 位置插入 ele 元素
        list.add(1,"BB");
        System.out.println(list);
        //addAll(int index,Collection eles) 从 index 位置开始将 eles 中的所有元素添加进来
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list);
        // Object get(int index) 获取指定 index 位置的元素
        System.out.println(list.get(0));
    }

    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Date());
        list.add(456);
        // int indexOf(Object obj) 返回 obj 在集合中首次出现的位置，如果不存在，就返回 -1
        int index = list.indexOf(456);
        System.out.println(index);
        // 没有对应元素就返回 -1
        System.out.println(list.indexOf(4567));
        // int lastIndexOf(Object obj) 返回 obj 在集合中末次出现的位置，如果不存在，就返回 -1
        System.out.println(list.lastIndexOf(456));
        // Object remove(int index) 移除指定 index 位置的元素，并返回此元素
        Object obj = list.remove(0);
        System.out.println(obj);
        System.out.println(list);
        // Object set(int index,Object ele) 设置指定 index 位置的元素为 ele
        list.set(1,"CC");
        System.out.println(list);
        // List subList(int fromIndex,int toIndex) 返回 [fromIndex,toIndex) 区间的子 list
        List subList = list.subList(2, 4);
        System.out.println(subList);
        System.out.println(list);
    }

    // 集合的元素的遍历
    @Test
    public void test3(){
        List list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Date());
        list.add(456);
        // 方式一：Iterator 迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("***********************");
        // 方式二：for each 循环
        for(Object obj : list){
            System.out.println(obj);
        }
        System.out.println("***********************");
        // 方式三：普通 forz
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    // 一个小练习：remove(int index) 和 remove(Object obj) 的区别
    @Test
    public void test4(){
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        // 删除索引为 2 的元素
//        list.remove(2);
//        System.out.println(list);
        // 删除值为 2 的元素
        list.remove(new Integer(2));
        System.out.println(list);
    }
}
