package pers.yangzhen.ordinaryclass.string;

import org.junit.Test;

/**
 * Sting类的一些方法
 * @author yangzhen
 * @create 2021-03-19 16:30
 */
public class StringTest {


    @Test
    public void test1(){
        String s1 = "abc";//字面量的定义方式
        String s2 = "abc";
        System.out.println(s1 == s2);//比较s1和s2的地址值
        s1 = "hello";
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("*************************");

        String s3 = "abc";
        s3 +="def";
        System.out.println(s3);//abcdef
        System.out.println(s2);//abc，说明并没有在"abc"后面加上def，而是重新在常量池开辟空间赋值"abcdef"

        System.out.println("*************************");
        String s4 = "abc";
        String s5 = s4.replace('a','m');
        System.out.println(s4);//abc
        System.out.println(s5);//mbc，说明replace()没有直接将字符替换，而在重新开辟空间赋值"mbc"
    }

    /*
     * String实例化的方式
     * 方式一：通过字面量
     * 方式二：通过new + 构造器的方式
     * */
    @Test
    public void test2(){
        //通过字面量：通过字面量定义的方式：此时的s1和s2的值"java"声明在在方法区中的字符串常量池中
        String s1 = "java";
        String s2 = "java";

        //通过new + 构造器的方式：此时的s3和s4保存地址值，是数据在堆空间开辟空间之后对应的地址值
        String s3 = new String("java");//new的结构都在堆空间中开辟空间
        String s4 = new String("java");

        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false
        System.out.println(s3 == s4);//false

        System.out.println("*************************");
        Person p1 = new Person("Tom",19);
        Person p2 = new Person("Tom",19);
        System.out.println(p1 == p2);//false
        System.out.println(p1.equals(p2));//false，p1中并未重写toString()，比较的仍是两个对象的地址值，即判断p1 == p2
        System.out.println(p1.name == p2.name);//true
        System.out.println(p1.name.equals(p2.name));//true

    }

    @Test
    public void test3(){
        /*常量与常量之间的拼接结果在常量池，且常量池中不会存在相同内容的常量
        * 但常量与变量之间的拼接结果在堆中
        * 如果拼接的结果调用intern()，返回值就在常量池中
        * */
        String s1 = "hello";
        String s2 = "world";
        String s3 = "hello" + "world";
        //上面3个变量存储的都是在常量池中的字符串的地址

        String s4 = s1 + "world";
        String s5 = s1 + s2;
        String s6 = (s1 + s2).intern();
        // 前2个变量s4 s5由于有变量参与，所以尽管字符串最后都是存在常量池中，但是变量存储的是堆中开辟的数组value的地址，
        // 数组中存储的值是常量池中字符串的地址，
        // 即变量中存储的是堆中的地址值，该地址存储的内容是常量池中字符串的地址
        //而s6最后调用了intern()，该方法返回常量池中字符串的地址

        System.out.println(s3 == s4);//false
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//true

        System.out.println(s4 == s5);//false
    }


    public void change(String str, char[] ch){
        str = "test ok";
        ch[0] = 'b';
    }
    @Test
    public void test4(){
        String str = new String("good");
        char[] ch = {'t','e','s','t'};

        change(str,ch);
        System.out.println(str);//good
        System.out.println(ch);//best

    }
}

class Person{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
