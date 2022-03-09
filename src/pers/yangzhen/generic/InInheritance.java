package pers.yangzhen.generic;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型在继承方面的体现
 * @author yangzhen
 * @create 2021-04-05 17:07
 */
public class InInheritance {
    @Test
    public void test1() {
        List<Object> list1 = null;
        List<String> list2 = null;
        // 编译不通过，此时的 list1 和 list2 并不具有子父类关系
        // list1 = list2;
    }

    @Test
    public void test2() {
        List<String> list = null;
        AbstractList<String> abstractList = null;
        ArrayList<String> arrayList = null;
        // ArrayList<String> 类是 List<String> 接口的实现类
        list = arrayList;
        // ArrayList<String> 类是 AbstractList<String> 类的子类
        abstractList = arrayList;
    }
}