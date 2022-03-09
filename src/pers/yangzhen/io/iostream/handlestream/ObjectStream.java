package pers.yangzhen.io.iostream.handlestream;

import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 *
 * @author yangzhen
 * @create 2021-04-09 21:36
 */
public class ObjectStream {
    
    // 序列化：将内存中的 Java 对象保存到磁盘或者通过网络传输出去
    @Test
    public void test1() {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("./src/pers/yangzhen/io/iostreamfiles/object.dat"));
            // 写入 2 个对象
            objectOutputStream.writeObject("好好学习，天天向上");
            objectOutputStream.writeObject(new Person("张三", 30));
            // 刷新
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    // 反序列化：将磁盘文件还原为内存中的 Java 对象
    @Test
    public void test2() {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(
                    new FileInputStream("./src/pers/yangzhen/io/iostreamfiles/object.dat"));
            // 按照写的顺序读
            String str = (String) objectInputStream.readObject();
            System.out.println(str);
            Person p = (Person) objectInputStream.readObject();
            System.out.println(p);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/*
 * Person 类需要满足如下的要求，方可序列化：
 * 1. 实现接口 Serializable
 * 2. 提供一个全局常量 serialVersionUID
 * 3. 保证当前类的所有的属性都是序列化的，其中：
 *      基本数据类型默认就是序列化的，String 实现了 Serializable ，已经序列化过了
 *      其他的类的对象作为属性时，该类必须显式地使其序列化
 * */
class Person implements Serializable {
    public static final long serialVersionUID = 42L;
    
    private String name;
    private int age;
    
    public Person() {
    }
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
    
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
