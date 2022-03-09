package pers.yangzhen.internet;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端发送文件给服务端，服务端将文件保存到本地
 *
 * @author yangzhen
 * @create 2021-04-11 17:09
 */
public class TCPTest2 {
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        InputStream inputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            serverSocket = new ServerSocket(9090);
            // 监听客户端的请求
            clientSocket = serverSocket.accept();
            inputStream = clientSocket.getInputStream();
            bufferedOutputStream = new BufferedOutputStream(
                    new FileOutputStream("./src/pers/yangzhen/internet/头像(CS端).jpg"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, len);
            }
            System.out.println("接收成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    @Test
    public void client() {
        Socket serverSocket = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            serverSocket = new Socket("127.0.0.1", 9090);
            outputStream = serverSocket.getOutputStream();
            // 客户端从本地读取文件
            bufferedInputStream = new BufferedInputStream(
                    new FileInputStream("./src/pers/yangzhen/io/iostreamfiles/头像src.jpg"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                // 将文件通过输出流写出去，发送给指定 IP 地址的端口
                outputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}