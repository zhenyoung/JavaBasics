package pers.yangzhen.internet;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP 协议的网络编程
 * @author yangzhen
 * @create 2021-04-11 21:11
 */
public class UDPTest {

    @Test
    public void sender(){
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            String str = "我是UDP发送的";
            byte[] data = str.getBytes();
            InetAddress inetAddress = InetAddress.getLocalHost();
            DatagramPacket packet = new DatagramPacket(
                    data,0,data.length,inetAddress,9090);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket != null){
                socket.close();
            }
        }
    }

    @Test
    public void receiver(){
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9090);
            byte[] buffer = new byte[100];
            DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);
            socket.receive(packet);
            System.out.println(new String(packet.getData(),0,packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket != null){
                socket.close();
            }
        }
    }
}