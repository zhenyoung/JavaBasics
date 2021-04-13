package pers.yangzhen.ordinaryclass.string;

import org.junit.Test;

/**
 * 关于StringBuffer和StringBuilder
 * @author yangzhen
 * @create 2021-03-20 16:57
 */
public class StringBufferBuilder {

    @Test
    public void test1(){
        String str = new String();//char[] value = new char[0];
        String str1 = new String("abc");//char[] value = new char[]{'a','b','c'};

        StringBuffer sb1 = new StringBuffer();//char[] value = new char[16];底层创建了一个长度为16的char[]
        System.out.println(sb1.length());//0，查看源码知道：StringBuffer类的length()不是返回数组的长度，而是返回数组元素的个数
        sb1.append('a');//value[0] = 'a';
        sb1.append('b');//value[1] = 'b';

        StringBuffer sb2 = new StringBuffer("abc");//char[] value = new char["abc".length() + 16]

        System.out.println(sb2.length());//3
        System.out.println(sb2);//abc，可变字符序列表，直接在原有的字符串基础上添加
    }


    /*
    * StringBuffer的常用方法：
    * StringBuffer append(xxx)：添加字符或字符串
    * StringBuffer delete(int start,int end)：删除[start,end)间索引位置的字符
    * StringBuffer replace(int start,int end,String str)：把[start,end)间的子串替换为str
    * StringBuffer insert(int offset,xxx)：在指定位置插入xxx
    * StringBuffer reverse()：把当前字符序列逆转
    * public int indexOf(String str)：同String，返回与含有str子串位置第一个字符的索引
    * public String substring(int start,int end)：返回一个从[start,end)索引的子串
    * public int length()
    * public char charAt(int n)
    *public void setCharAt(int n,char ch)
    *
    * 总结起来就是：
    *               增：append(xxx)
    *               删：delete(int start,int end)
    *               改：setCharAt(int n,char ch)/replace(int start,int end,String str)
    *               查：charAt(int n)
    *               插：insert(int offset,xxx)
    *              长度：length()
    *              遍历：toString()
     * */
    @Test
    public void test2(){
        StringBuffer s1 = new StringBuffer("abcdef");

        s1.append(1);
        s1.append('1');
        System.out.println(s1);//abcdef11，与String一样，不写toString()就默认调用了

        s1.delete(2,4);
        System.out.println(s1);//abef11

        s1.replace(2,4,"hello");
        System.out.println(s1);//abhello11

        s1.insert(2,false);
        System.out.println(s1);//abfalsehello11
        s1.insert(2,"xyz");
        System.out.println(s1);//abxyzfalsehello11

        s1.reverse();
        System.out.println(s1);//11olleheslafzyxba

        System.out.println(s1.substring(0,4));//11ol

    }

}
