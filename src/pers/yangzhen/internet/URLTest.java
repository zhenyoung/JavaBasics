package pers.yangzhen.internet;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author yangzhen
 * @create 2021-04-11 21:30
 */
public class URLTest {
    @Test
    public void test1(){
        URL url;
        try {
            url = new URL("https://space.bilibili.com/927587/dynamic");
            // public String getProtocol() 获取协议名
            System.out.println(url.getProtocol());
            // public String getHost() 获取主机名
            System.out.println(url.getHost());
            // public int getPort() 获取端口号
            System.out.println(url.getPort());
            // public String getPath() 获取文件路径
            System.out.println(url.getPath());
            // public String getFile() 获取文件名
            System.out.println(url.getFile());
            // public String getQuery() 获取 URL 的查询名
            System.out.println(url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}