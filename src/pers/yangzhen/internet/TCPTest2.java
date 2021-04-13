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
        Socket socket = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        try {
            serverSocket = new ServerSocket(9090);
            socket = serverSocket.accept();

            //获取输入流读取服务端的输出流的文件
            is = socket.getInputStream();

            //输出文件路径
            bos = new BufferedOutputStream(new FileOutputStream("E:/IDEAProject/JavaBasics/src/pers/yangzhen/internet/头像(CS端).jpg"));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                bos.write(buffer, 0, len);//将文件通过bos流写到指定路径下
            }
            System.out.println("接收成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
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
        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        try {
            socket = new Socket("127.0.0.1", 9090);
            os = socket.getOutputStream();

            //客户端从本地读取文件
            bis = new BufferedInputStream(new FileInputStream("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/iostreamdocuments/头像.jpg"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {//将文件从指定位置读到输入流中
                os.write(buffer, 0, len);//将文件通过输出流写出去，发送给指定IP地址下的端口
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}