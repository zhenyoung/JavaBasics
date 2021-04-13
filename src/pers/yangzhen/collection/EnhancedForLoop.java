package pers.yangzhen.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 增强for循环用来遍历数组或者集合
 *
 * @author yangzhen
 * @create 2021-03-26 23:16
 */
public class EnhancedForLoop {

    //遍历集合元素
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person1("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //for(数组元素的类型 局部变量 : 集合对象)
        //实际上，内部仍然是在调用迭代器
        for (Object obj : coll) {
            System.out.println(obj);
        }

    }

    //遍历数组
    @Test
    public void test2(){
        int[] arr1 = new int[]{1,2,3,4,5,6};
        String[] arr2 = new String[]{"AA","BB","CC"};

        //for(数组元素的类型 局部变量 : 数组对象)
        for(int i : arr1){
            System.out.println(i);
        }

        for(String s : arr2){
            System.out.println(s);
        }
    }

}
