package pers.yangzhen.io.iostream;

import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 * @author yangzhen
 * @create 2021-04-09 21:36
 */
public class ObjectInputOutputStream {

    //序列化：将内存中的java对象保存到磁盘或者通过网络传输出去
    @Test
    public void testObjectOutputStream(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/iostreamdocuments/object.dat"));
            oos.writeObject(new String("好好学习，天天向上"));
            oos.writeObject(new Person("张三",30));
            oos.flush();//刷新
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //反序列化：将磁盘文件中的对象还原为内存中的1个Java对象
    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/iostreamdocuments/object.dat"));

            //按照写的顺序读
            Object obj = ois.readObject();
            System.out.println((String) obj);

            Person p = (Person) ois.readObject();
            System.out.println(p);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}


/*
 * Person类需要满足如下的要求，方可序列化：
 * 1.实现接口Serializable
 * 2.提供一个全局常量serialVersionUID
 * 3.保证当前类的所有的属性都是序列化的，基本数据类型默认就是序列化的，其他的类的对象作为属性时，该类必须显式地使其序列化
 * */
class Person implements Serializable{
    public static final long serialVersionUID = 42L;//序列版本号

    private String name;
    private int age;

    public Person(){
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
