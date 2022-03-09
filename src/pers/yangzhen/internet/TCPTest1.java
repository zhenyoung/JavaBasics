package pers.yangzhen.internet;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端与服务端之间的数据通信
 * @author yangzhen
 * @create 2021-04-10 17:04
 */
public class TCPTest1 {
    @Test
    public void server(){
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            // 创建服务器端的 Socket，指明服务器的端口号，
            // 由于服务器就是在本机上跑的，所以这里服务器的 ip 不用指明
            serverSocket = new ServerSocket(8899);
            // 调用 accept() 表示接收来自客户端的 Socket
            clientSocket = serverSocket.accept();
            // 获取输入流
            inputStream = clientSocket.getInputStream();
            // 读取输入流的数据
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = inputStream.read(buffer)) != -1){
                // InputStream 字节流读取汉字可能会出现乱码，所以这里用 ByteArrayOutputStream 流来读取
                // 将字符写到 byteArrayOutputStream 的 buf 数组中
                byteArrayOutputStream.write(buffer,0,len);
            }
            // 打印 byteArrayOutputStream 的 buf 数组
            System.out.println(byteArrayOutputStream);
            System.out.println("收到了来自于：" + clientSocket.getInetAddress().getHostAddress() + "的信息");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(clientSocket != null){
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(byteArrayOutputStream != null){
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    @Test
    public void client(){
        Socket serverSocket = null;
        OutputStream outputStream = null;
        try {
            serverSocket = new Socket("127.0.0.1", 8899);
            outputStream = serverSocket.getOutputStream();
            outputStream.write("这是来自客户端的一则信息".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}