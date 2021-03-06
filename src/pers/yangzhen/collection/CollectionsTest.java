package pers.yangzhen.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections 工具类测试
 * @author yangzhen
 * @create 2021-04-04 21:46
 */
public class CollectionsTest {
    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(123);
        list.add(12);
        list.add(19);
        list.add(10);
        list.add(-3);
        list.add(89);
        System.out.println("初始集合为：" + list);
        Collections.reverse(list);
        System.out.println("上一个集合逆序：" + list);
        Collections.shuffle(list);
        System.out.println("上一个集合随机排序：" + list);
        Collections.sort(list);
        System.out.println("上一个集合升序排序：" + list);
        Collections.swap(list, 0, 1);
        System.out.println("上一个集合元素交换：" + list);
        int frequency = Collections.frequency(list, 123);
        System.out.println("123 在集合中一共出现了" + frequency + "次");
        
        // 运行时报异常 java.lang.IndexOutOfBoundsException ，
        // 因为 copy 方法的参数为 List<? super T> 泛型，ArrayList 是 List 的子类，不满足
//        List dest = new ArrayList();
//        Collections.copy(dest,list);
        
        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);
        System.out.println("复制方法copy" + dest);
        // 此时的 list1 就是线程安全的，其他集合也是类似的，这里不再赘述
        List list1 = Collections.synchronizedList(list);
    }
}
