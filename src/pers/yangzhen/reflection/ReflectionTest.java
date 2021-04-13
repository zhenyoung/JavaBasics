package pers.yangzhen.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射
 * @author yangzhen
 * @create 2021-04-12 16:31
 */
public class ReflectionTest {

    //前两个测试方法仅仅作为功能的演示
    //反射之前，对于Person类的操作
    @Test
    public void test1(){
        Person p1 = new Person("Tom", 12);
        p1.age = 10;
        System.out.println(p1);
        p1.show();

        //在Person类外部，不能通过Person类的对象调用其内部的私有结构
        //比如私有属性name，方法showNation()以及私有的构造器
    }

    //有了反射之后，对于Person的操作
    @Test
    public void test2() throws Exception{
        Class<Person> personClass = Person.class;
        //1.通过反射创建Person类的对象
        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        Person p = constructor.newInstance("Tom", 12);
        System.out.println(p);

        //2.通过反射，调用对象指定的属性和方法
        //调用属性
        Field age = personClass.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p);
        //调用方法
        Method show = personClass.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("**********************");
        //通过反射，是可以调用Person类的私有结构
        //调用私有的构造器
        Constructor<Person> constructor1 = personClass.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Person p1 = constructor1.newInstance("Mary");
        System.out.println(p1);

        //调用私有的属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"LiHua");
        System.out.println(p1);
        //调用私有的方法
        Method showNation = personClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1,"中国");//相当于String nation = p1.showNation("中国")
        System.out.println(nation);

    }


    //获取（Class不能创建对象）Class实例的四种方式：
    @Test
    public void test3() throws ClassNotFoundException {
        //1.调用运行时类的属性：.class
        Class<Person> personClass1 = Person.class;
        System.out.println(personClass1);
        //2.通过运行时类的对象
        Person person1 = new Person();
        Class<? extends Person> personClass2 = person1.getClass();
        System.out.println(personClass2);
        //3.调用Class的静态方法：forName(String classPath)，使用较频繁
        Class<?> personClass3 = Class.forName("pers.yangzhen.reflection.Person");
        System.out.println(personClass3);
        System.out.println(personClass1 == personClass2);//true
        System.out.println(personClass1 == personClass3);//true

        //4.类的加载器：ClassLoader（了解即可）
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> personClass4 = classLoader.loadClass("pers.yangzhen.reflection.Person");
        System.out.println(personClass1 == personClass4);//true
    }

}

class Person{
    private String name;
    int age;

    public Person(){
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    private Person(String name){
        this.name = name;
    }

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

    public void show(){
        System.out.println("我是一个好人");
    }

    private String showNation(String nation){
        System.out.println("我是" + nation + "人");
        return nation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
