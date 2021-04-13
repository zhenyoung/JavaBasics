package pers.yangzhen.collection;

import org.junit.Test;

import java.util.*;

/**
 * 测试Collection中的方法
 *
 * @author yangzhen
 * @create 2021-03-25 16:54
 */
public class CollectionMethodTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();

        //add(Object e)：将元素e添加到集合coll中
        coll.add("AA");
        coll.add("BB");
        coll.add(123);//自动装箱
        coll.add(new Date());

        //size()：获取添加的元素的个数
        System.out.println(coll.size());//4

        //addAll(Collection coll1)：将coll1集合中的全部元素添加到当前的集合中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add(new Person("Tom", 18));
        coll.addAll(coll1);
        System.out.println(coll.size());//6
        System.out.println(coll);//各个元素值

        //clear()清空集合元素
        coll.clear();

        //isEmpty()：判断当前集合是否有元素
        System.out.println(coll.isEmpty());//true
    }


    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(345);
        coll.add("Hello");
        coll.add(new String("World"));
        coll.add(new Person("Tom", 12));

        //contains(Object obj)：判断当前集合是否包含obj
        System.out.println(coll.contains(123));//true

        System.out.println(coll.contains(new String("World")));//true
        System.out.println(coll.contains(new Person("Tom", 12)));//false
        //在判断时，会去调用obj对象所在类的equals()，所以一般默认在Collections接口的实现类的对象中添加数据obj时，要求obj所在类重写equals()

        //containsAll(Collection coll1)：判断形参coll2中所有元素是否全部都存在于当前集合中，像contains()一样，都会去调用equals()
        Collection coll1 = Arrays.asList(123, 456);
        Collection coll2 = Arrays.asList(123, 345);
        System.out.println(coll.containsAll(coll1));//false
        System.out.println(coll.containsAll(coll2));//true
    }


    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person1("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //remove(Object obj)移除指定元素obj，同contains()一样，都会去调用equals()
        System.out.println(coll.remove(123));//true，移除成功
        System.out.println(coll);
        coll.remove(new Person1("Jerry", 20));//true，移除成功
        System.out.println(coll);//因为在Person1类中重写了equals()，是可以比较两者内容的，所以可以移除成功

        //removeAll(Collection coll1)：从当前集合中移除coll1中所有的元素，也会调equals()
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

        //removeAll类似数学中的差集
        //与之对应地，与交集类似的为retainAll(Collection coll1)
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
        //coll对象的hashCode()是继承于Object类中hashCode()的，返回当前对象的哈希值
        System.out.println(coll.hashCode());//701070075

        //toArray()：集合--->数组
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //数组--->集合
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List arr1 = Arrays.asList(new int[]{123,456});
        System.out.println(arr1.size());//1，默认上述int数组的两个元素被当作一个元素了
        List arr2 = Arrays.asList(new Integer[]{123,456});
        System.out.println(arr2.size());//2，用Integer包装类是可以的

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
