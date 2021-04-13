package pers.yangzhen.collection.set;

import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @author yangzhen
 * @create 2021-03-28 13:35
 */
public class SetTest {

    //hashset
    @Test
    public void test1(){
        HashSet hashSet = new HashSet();
        hashSet.add(123);
        hashSet.add("AA");
        hashSet.add(new Date());
        hashSet.add('B');
        hashSet.add(1.4);
        hashSet.add('B');
        System.out.println(hashSet);
    }

    //LinkedHashSet
    @Test
    public void test2(){
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(123);
        linkedHashSet.add("AA");
        linkedHashSet.add(new Date());
        linkedHashSet.add('B');
        linkedHashSet.add(1.4);
        System.out.println(linkedHashSet);
    }




}
