package pers.yangzhen.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历操作，使用迭代器Iterator接口
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
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();//Collection类下的iterator()返回一个Iterator类型的对象

//        System.out.println(iterator.next());//next()返回下一个元素值
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }

        //前两种遍历的写法都不常用，更习惯下面的写法
        while (iterator.hasNext()){//hasNext()查询后面是否还有元素
            //next():①指针下移 ②将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }

        //注意：下面两种写法都是错的
        //1.
//        while(iterator.next() != null){
//            System.out.println(iterator.next());
//        }
        //2.
//        while (coll.iterator().hasNext()){
//            System.out.println(coll.iterator().next());
//        }
    }

    //测试Iterator中的remove()
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person1("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
            }
        }

        //此时的iterator的游标（或者叫指针）已经到了最后一个的后面，
        //若想重新遍历集合，则必须重新生成一个迭代器，使得游标位于第一个元素之前
        iterator = coll.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
