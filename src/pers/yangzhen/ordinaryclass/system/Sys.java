package pers.yangzhen.ordinaryclass.system;

import org.junit.Test;

/**
 * System类的String getProperty(String key)
 * @author yangzhen
 * @create 2021-03-24 10:34
 */
public class Sys {
    @Test
    public void test(){
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("java.dir"));
    }
}
