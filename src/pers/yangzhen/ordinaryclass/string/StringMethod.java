package pers.yangzhen.ordinaryclass.string;

import org.junit.Test;

/**
 * 介绍一下String类中的常用方法
 *
 * @author yangzhen
 * @create 2021-03-20 11:54
 */
public class StringMethod {
    @Test
    public void test1() {
        String s1 = "Hello,World";
        System.out.println(s1.length());//11，返回字符串中字符数目：return value.length
        System.out.println(s1.charAt(0));//H，返回字符串指定索引位置的字符：return value[index]
        System.out.println(s1.charAt(1));//e
        System.out.println(s1.charAt(10));//d
//        System.out.println(s1.charAt(11));//报异常，s1索引最大为10
        System.out.println(s1.isEmpty());//false，判断是否是空字符串：return value.length == 0

        String s2 = s1.toUpperCase();
        System.out.println(s1);//不变，String的不可变性
        System.out.println(s2);//HELLO,WORLD，将小写字母转换成大写字母
        System.out.println(s1.toLowerCase());//hello,world，将大写字母转换成小写字母

        String s3 = "   he  llo      world   ";
        String s4 = s3.trim();//去除字符串首尾的空白
        System.out.println("--------" + s3 + "-------------");
        System.out.println("--------" + s4 + "-------------");

        String s5 = "HelloWorld";
        String s6 = "helloworld";
        System.out.println(s5.equals(s6));//false
        System.out.println(s5.equalsIgnoreCase(s6));//true，忽略大小写比较两个字符串是否相等

        String s7 = "abc";
        s7 = s7.concat(s5);
        System.out.println(s7);//连接两个字符串，等价于”+“，以后用”+“即可

        String s8 = "abc";
        String s9 = "adc";
        System.out.println(s8.compareTo(s9));//比较两个字符串的大小。负数，当前对象s8小；0，相等；正数，s9大

        String s10 = "北京欢迎你";
        String s11 = s10.substring(2);//返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后一个的子字符串
        String s12 = s10.substring(0, 2);//返回一个新的字符串，从beginIndex到endIndex之间（不包括endIndex）的字符
        System.out.println(s10);
        System.out.println(s11);
        System.out.println(s12);
    }

    @Test
    public void test2() {
        String str1 = "HelloWorld";
        System.out.println(str1.endsWith("rld"));//endWith()测试字符串是否以指定的后缀结束
        System.out.println(str1.startsWith("Hel"));//startsWith()测试字符串是否以指定的前缀开始
        System.out.println(str1.startsWith("ll",2));//测试从指定索引开始的 子字符串是否是以自定的前缀开始
        System.out.println();

        String str2 = "wor";
        System.out.println(str1.contains(str2));//contains()测试str1是否包含str2子串

        System.out.println(str1.indexOf("Wor"));//indexOf()返回指定子字符串在此字符串中第一次出现处的索引，
        System.out.println(str1.indexOf("lo",5));//返回从指定索引开始的指定子字符串在此字符串中第一次出现处的索引，
        System.out.println(str1.lastIndexOf("lo"));//返回指定字符串在此字符串最右边出现处（最后一次出现）的索引
        System.out.println(str1.lastIndexOf("lo",6));//从指定索引开始，从右往左开始查找最后一次出现字串的索引
        //注：indexOf和lastIndexOf方法如果未找到都是返回-1
        //什么情况下，indexOf(str)和lastIndexOf(str)返回值相同？
        //答：该字符串中只存在唯一的一个子串str，或者不存在str（此时返回值为-1）
    }

    @Test
    public void test3(){
        String str1 = "北京欢迎你";
        System.out.println(str1);//北京欢迎你
        System.out.println(str1.replace('北','南'));//南京欢迎你
        System.out.println(str1.replace("北京","上海"));//上海欢迎你

    }
}
