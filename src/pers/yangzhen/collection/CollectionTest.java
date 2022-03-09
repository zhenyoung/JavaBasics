package pers.yangzhen.collection;

import org.junit.Test;

import java.util.*;

/**
 * 测试 Collection 中的方法
 * @author yangzhen
 * @create 2021-03-25 16:54
 */
public class CollectionTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        // add(Object e)：将元素 e 添加到集合 coll 中
        coll.add("AA");
        coll.add("BB");
        // 自动装箱
        coll.add(123);
        coll.add(new Date());
        // size()：获取添加的元素的个数
        System.out.println(coll.size());
        // addAll(Collection coll1)：
        // 将 coll1 集合中的全部元素添加到当前集合 coll 中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add(new Person("Tom", 18));
        coll.addAll(coll1);
        System.out.println(coll.size());
        System.out.println(coll);
        // clear() 清空集合元素
        coll.clear();
        // isEmpty()：判断当前集合是否有元素
        System.out.println(coll.isEmpty());
    }
    
    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(345);
        coll.add("Hello");
        coll.add("World");
        coll.add(new Person("Tom", 12));
        // 在判断时，会去调用 obj 所在类的 equals() ，所以一般约定：
        // 在 Collections 实现类的对象中添加数据 obj 时，要求 obj 所在类重写 equals()
        // contains(Object obj)：判断当前集合是否包含 obj ，底层调用 equals 方法实现判断
        System.out.println(coll.contains(123));
        System.out.println(coll.contains("World"));
        System.out.println(coll.contains(new Person("Tom", 12)));
        // containsAll(Collection coll1)：
        // 判断形参 coll2 中所有元素是否全部都存在于当前集合中，
        // 像 contains() 一样，通过调用 equals() 实现判断
        Collection coll1 = Arrays.asList(123, 456);
        Collection coll2 = Arrays.asList(123, 345);
        System.out.println(coll.containsAll(coll1));
        System.out.println(coll.containsAll(coll2));
    }
    
    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person1("Jerry", 20));
        coll.add("Tom");
        coll.add(false);
        // remove(Object obj) 移除指定元素 obj ，同 contains() 一样，都会去调用 equals()
        System.out.println(coll.remove(123));
        System.out.println(coll);
        coll.remove(new Person1("Jerry", 20));
        // 因为在 Person1 类中重写了 equals() ，是可以比较两者内容的，所以可以移除成功
        System.out.println(coll);
        // removeAll(Collection coll1)：从当前集合中移除 coll1 中所有的元素，也会调 equals()
        Collection coll1 = Arrays.asList("Tom", false);
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test4() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person1("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);
        // removeAll 类似数学中的差集，与之对应地，
        // 与交集类似的为 retainAll(Collection coll1)
        Collection coll1 = Arrays.asList(123, 456, 789);
        coll.retainAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test5() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person1("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);
        // coll 对象的 hashCode() 是继承于 Object 类中的，返回当前对象的哈希值
        System.out.println(coll.hashCode());
        // toArray()：集合--->数组
        Object[] arr = coll.toArray();
        for (Object o : arr) {
            System.out.println(o);
        }
        // asList ：数组--->集合
        List<String> list = Arrays.asList("AA", "BB", "CC");
        System.out.println(list);
        // 上述 int 数组作为 arr1 集合的一个元素
        List arr1 = Arrays.asList(new int[]{123,456});
        System.out.println(arr1.size());
        // Integer 数组则是作为两个元素，等价于 asList(123,456)
        List arr2 = Arrays.asList(new Integer[]{123,456});
        System.out.println(arr2.size());
    }
}

class Person {

    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Person1 {

    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person1() {
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person1 person1 = (Person1) o;

        if (age != person1.age) return false;
        return Objects.equals(name, person1.name);
    }
}
