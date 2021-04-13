package pers.yangzhen.ordinaryclass.string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 介绍一些其他的String类型的转化
 * @author yangzhen
 * @create 2021-03-20 16:11
 */
public class DataConvert {

    /*
    * String--->char[]：调用String的toCharArray()
    * char[]--->String：调用String的构造器
    * */
    @Test
    public void test1(){

        String s1 = "abc123";
        char[] charArray = s1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
        }
        System.out.println();
        char[] arr = new char[]{'h','e','l','l','o'};
        String s2 = new String(arr);
        System.out.println(s2);
    }

    /*
    * String--->byte[]之间的转换
    * */
    @Test
    public void test2() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        byte[] bytes1 = str1.getBytes();//使用默认的字符集进行编码
        System.out.println(Arrays.toString(bytes1));
        System.out.println(new String(bytes1));//使用默认的字符集进行解码
        System.out.println("**************************");
        byte[] bytes2 = str1.getBytes("GBK");//使用GBK字符集编码
        System.out.println(Arrays.toString(bytes2));
        System.out.println(new String(bytes2,"GBK"));//使用GKB字符集解码
    }
}
