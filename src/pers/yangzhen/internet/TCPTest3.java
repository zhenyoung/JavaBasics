package pers.yangzhen.internet;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端接收到客户端的数据后，发送反馈给客户端
 * @author yangzhen
 * @create 2021-04-11 20:19
 */
public class TCPTest3 {

    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        InputStream inputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        OutputStream outputStream = null;
        try {
            serverSocket = new ServerSocket(9090);
            clientSocket = serverSocket.accept();
            inputStream = clientSocket.getInputStream();
            bufferedOutputStream = new BufferedOutputStream(
                    new FileOutputStream("./src/pers/yangzhen/internet/头像(CS端2).jpg"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                // 将文件通过 bufferedOutputStream 流写到指定路径下
                bufferedOutputStream.write(buffer, 0, len);
            }
            System.out.println("接收成功");
            // 服务器给客户端反馈
            outputStream = clientSocket.getOutputStream();
            outputStream.write("服务器成功接收到数据，现反馈给你客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
        Socket clientSocket = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            clientSocket = new Socket("127.0.0.1", 9090);
            outputStream = clientSocket.getOutputStream();
            // 客户端从本地读取文件
            bufferedInputStream = new BufferedInputStream(
                    new FileInputStream("./src/pers/yangzhen/io/iostreamfiles/头像src.jpg"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            // 关闭数据的输出
            clientSocket.shutdownOutput();
            
            // 接收服务器返回的数据
            InputStream inputStream = clientSocket.getInputStream();
            // 为了使得数据不乱码，使用 ByteArrayOutputStream 流
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer1 = new byte[20];
            int len1;
            while ((len1 = inputStream.read(buffer1)) != -1){
                byteArrayOutputStream.write(buffer1,0,len1);
            }
            // 显示到控制台上
            System.out.println(byteArrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}