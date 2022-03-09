package pers.yangzhen.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历操作，使用迭代器 Iterator 接口，for each 循环
 * @author yangzhen
 * @create 2021-03-25 21:38
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person1("Jerry", 20));
        coll.add("Tom");
        coll.add(false);
        // Collection 类下的 iterator() 返回一个 Iterator 类型的对象
        Iterator iterator = coll.iterator();
        // hasNext() 查询后面是否还有元素
        while (iterator.hasNext()){
            // next(): ①指针下移 ②将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }
        // 实际上这里使用 for each 循环更加简洁，编译器会将 for each 转换成迭代器遍历
        // 因此两者效率是相同的，不过 for each 循环仅仅在遍历时简洁，
        // 如果循环里面要进行一些其他操作，
        // 那么 for each 循环将无能为力，因为它的语法是固定死了的，不能像迭代器那样灵活多变
        
        // 以下是两种典型的“个性”错误
//        1.
//        while(iterator.next() != null){
//            System.out.println(iterator.next());
//        }
//        2.
//        while (coll.iterator().hasNext()){
//            System.out.println(coll.iterator().next());
//        }
    }

    // 测试 Iterator 中的 remove()
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person1("Jerry", 20));
        coll.add("Tom");
        coll.add(false);
        Iterator iterator = coll.iterator();
        // for each 循环就无法实现下面的判断操作了，它只能用于遍历
        while (iterator.hasNext()){
            Object obj = iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
            }
        }
        // 此时的 iterator 的游标(或者叫指针)已经到了最后一个的后面，
        // 若想重新遍历集合，则必须重新生成一个迭代器，使得游标位于第一个元素之前
        iterator = coll.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    
    // 遍历集合
    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person1("Jerry", 20));
        coll.add("Tom");
        coll.add(false);
        // obj 接收集合的元素
        for (Object obj : coll) {
            System.out.println(obj);
        }
    }
    
    // 遍历数组
    @Test
    public void test4(){
        int[] arr1 = new int[]{1,2,3,4,5,6};
        String[] arr2 = new String[]{"AA","BB","CC"};
        // value 用来接受数组的元素
        for(int value : arr1){
            System.out.println(value);
        }
        for(String s : arr2){
            System.out.println(s);
        }
    }
}
