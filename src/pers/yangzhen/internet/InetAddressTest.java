package pers.yangzhen.internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author yangzhen
 * @create 2021-04-10 15:59
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("112.80.248.76");
            System.out.println(inet1);
            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println(localhost);
            System.out.println(inet2.getHostName());
            System.out.println(inet2.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}